package com.marvel.MarvelAPI;

import com.marvel.MarvelAPI.Security.Persistence.Entity.PermissionEntity;
import com.marvel.MarvelAPI.Security.Persistence.Entity.RoleEnum;
import com.marvel.MarvelAPI.Security.Persistence.Entity.RolesEntity;
import com.marvel.MarvelAPI.Security.Persistence.Entity.UserEntity;
import com.marvel.MarvelAPI.Security.Persistence.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class MarvelApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarvelApiApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			/* Crear Permisos */
			PermissionEntity createPermission = PermissionEntity.builder()
					.name("CREATE")
					.build();

			PermissionEntity readPermission = PermissionEntity.builder()
					.name("READ")
					.build();

			PermissionEntity updatePermission = PermissionEntity.builder()
					.name("UPDATE")
					.build();

			PermissionEntity deletePermission = PermissionEntity.builder()
					.name("DELETE")
					.build();



			/* Create roles */
			RolesEntity roleAdmin = RolesEntity.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
					.build();

			RolesEntity roleUser = RolesEntity.builder()
					.roleEnum(RoleEnum.USER)
					.permissionList(Set.of(createPermission, readPermission))
					.build();



			/* crear usuarios iniciales*/
			UserEntity userAdmin = UserEntity.builder()
					.username("admin")
					.password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleAdmin))
					.build();

			UserEntity user1 = UserEntity.builder()
					.username("user1")
					.password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleUser))
					.build();




			userRepository.saveAll(List.of(userAdmin, user1));
		};
	}

}
