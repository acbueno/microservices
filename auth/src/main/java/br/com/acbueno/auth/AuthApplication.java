package br.com.acbueno.auth;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import br.com.acbueno.auth.entity.Permission;
import br.com.acbueno.auth.entity.User;
import br.com.acbueno.auth.repository.PermissionRepository;
import br.com.acbueno.auth.repository.UserRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthApplication {

  public static void main(String[] args) {
    SpringApplication.run(AuthApplication.class, args);
  }

  @Bean
  CommandLineRunner init(UserRepository userRepository, PermissionRepository permissionRepository, BCryptPasswordEncoder passwordEnconder) {
	  return args -> {
	    initUsers(userRepository, permissionRepository, passwordEnconder);
	  };
	}

  private void initUsers(UserRepository userRepository, PermissionRepository permissionRepository, BCryptPasswordEncoder passwordEnconder) {
	  Permission permission = null;
	  Permission findPermission = permissionRepository.findByDescription("Admin");
	  if(findPermission == null) {
	    permission = new Permission();
	    permission.setDescription("Admin");
	    permission = permissionRepository.save(permission);
	  } else {
	    permission = findPermission;
	  }
	  
	  User admin = new User();
	  admin.setUserName("rambo");
	  admin.setAccountNonExpired(true);
	  admin.setAccountNonLocked(true);
	  admin.setCredentialsNonExpired(true);
	  admin.setEnabled(true);
	  admin.setPassword(passwordEnconder.encode("rambo"));
	  admin.setPermissions(Arrays.asList(permission));
	  
	  User find = userRepository.findByUserName("rambo");
	  
	  if(find == null ) {
	    userRepository.save(admin);
	  }
	}

}
