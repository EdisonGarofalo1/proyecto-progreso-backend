package com.multibranch.app.services.user;

import com.multibranch.app.entities.GenericResponseEntity;
import com.multibranch.app.entities.TSEntity;
import com.multibranch.app.entities.enume.EMessage;
import com.multibranch.app.entities.request.user.OurUsers;
import com.multibranch.app.entities.request.user.UserSaveRequestEntity;
import com.multibranch.app.entities.request.user.UserUpdateRequestEntity;
import com.multibranch.app.exception.DataSourceException;
import com.multibranch.app.repositories.user.IUserRepository;
import com.multibranch.app.utils.JWTUtils;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.multibranch.app.utils.ResponseUtils.*;
import static com.multibranch.app.utils.ValidationUtils.isValidRequest;
@AllArgsConstructor
@Service
public class UserService  implements  IUserService{
    private IUserRepository repository;
    private JdbcTemplate jdbcTemplate;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JWTUtils jwtUtils;
    @Override
    public TSEntity<List<Map<String, Object>>> getAllUsers() throws DataSourceException {
        TSEntity<List<Map<String, Object>>> response = new TSEntity<>();
        try {
            List<Map<String, Object>>  result = this.repository.getAllUsers();
            response.setData(result);
        } catch (DataSourceException e) {
            response.setCode(e.getCode());
            response.setMessage(e.getPersonalizedMessage());
        }
        return response;
    }

    @Override
    public TSEntity<Map<String, Object>> getUserById(Map<String, Integer> request) throws DataSourceException {
        TSEntity<Map<String, Object>> response = new TSEntity<>();
        if (!isValidRequest(request, "idUser")) {
            return buildMapErrorResponse();
        }
        try {
            int idUser = request.get("idUser");
            List<Map<String, Object>> result = repository.getUserById(idUser);
            if (isNotFound(result)) {
                return buildMapErrorResponse(EMessage.NOTFOUND.getCode(), (String) result.getFirst().get("message"));
            }
            response.setData(result.getFirst());
        } catch (DataSourceException e) {
            return buildMapErrorResponse(e.getCode(), e.getPersonalizedMessage());
        }
        return response;
    }

    @Override
    public TSEntity<GenericResponseEntity> save(UserSaveRequestEntity request, BindingResult bindingResult) throws DataSourceException {
        TSEntity<GenericResponseEntity> response = new TSEntity<>();
        TSEntity<GenericResponseEntity> errorResponse = handleValidationErrors(bindingResult);
        if (errorResponse != null) {
            return errorResponse;
        }
        try {
            Map<String, Object> result = this.repository.save(this.jdbcTemplate, request.getNumeroIdentificacion(),
                                                            request.getCorreoElectronico(),request.getDireccion(),
                                                            request.getTelefono(),request.getUsername(),
                    passwordEncoder.encode( request.getPassword()),request.getRol(),request.getIdSucursal());
            if (result.containsKey("message")) {
                response.setMessage((String) result.get("message"));
            }
        } catch (DataSourceException e) {
            response.setCode(e.getCode());
            response.setMessage(e.getPersonalizedMessage());
        }
        return response;
    }

    @Override
    public TSEntity<GenericResponseEntity> update(UserUpdateRequestEntity request, BindingResult bindingResult) throws DataSourceException {
        TSEntity<GenericResponseEntity> response = new TSEntity<>();
        TSEntity<GenericResponseEntity> errorResponse = handleValidationErrors(bindingResult);
        if (errorResponse != null) {
            return errorResponse;
        }
        try {
            Map<String, Object> result = this.repository.update(this.jdbcTemplate, request.getIdUsuario(),
                    request.getNumeroIdentificacion(),
                    request.getCorreoElectronico(),request.getDireccion(),
                    request.getTelefono(),request.getUsername(),
                    passwordEncoder.encode( request.getPassword()),request.getRol(),request.getIdSucursal());
            if (result.containsKey("message")) {
                response.setMessage((String) result.get("message"));
            }
        } catch (DataSourceException e) {
            response.setCode(e.getCode());
            response.setMessage(e.getPersonalizedMessage());
        }
        return response;
    }

    @Override
    public TSEntity<GenericResponseEntity> delete(Map<String, Integer> request) throws DataSourceException {
        TSEntity<GenericResponseEntity> response = new TSEntity<>();
        if (!isValidRequest(request, "idUser")) {
            return buildGenericErrorResponse();
        }
        try {
            int idUser = request.get("idUser");
            Map<String, Object>  result = repository.delete(this.jdbcTemplate,idUser);
            if (result.containsKey("message")) {
                response.setMessage((String) result.get("message"));
            }
        } catch (DataSourceException e) {
            return buildGenericErrorResponse(e.getCode(), e.getPersonalizedMessage());
        }
        return response;
    }

    @Override
    public TSEntity<Map<String, Object>> login(UserSaveRequestEntity request, BindingResult bindingResult) throws DataSourceException {
        TSEntity<Map<String, Object>> response = new TSEntity<>();
        try {
//            List<Map<String, Object>> result = repository.login(request.getUsername(), passwordEncoder.encode( request.getPassword()));
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),
                            request.getPassword()));

            List<Map<String, Object>> result     = repository.findByUserName(request.getUsername());
            OurUsers user = new OurUsers();

            if (!result.isEmpty()) {
                Map<String, Object> row = result.get(0); // Tomamos el primer resultado de la lista
                user.setName((String) row.get("name"));  // Asignamos el valor de "name" al objeto user
                // Puedes agregar más propiedades del usuario aquí, por ejemplo:
                user.setEmail((String) row.get("email"));
            } else {
                // Maneja el caso en el que no hay resultados
                throw new RuntimeException("User not found");
            }
            UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                    request.getUsername(),
                    request.getPassword(),
                    new ArrayList<>()
            );
            // Generar el token JWT usando el email como identificador
            var jwt = jwtUtils.generateToken(userDetails);
            var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), userDetails);

            // Agregar los tokens a la respuesta
            Map<String, Object> data = new HashMap<>();
            data.put("jwt", jwt);
            data.put("refreshToken", refreshToken);
            response.setData(data);

        } catch (DataSourceException e) {
            return buildMapErrorResponse(e.getCode(), e.getPersonalizedMessage());
        }
        return response;
    }
}
