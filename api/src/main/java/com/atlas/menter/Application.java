package com.atlas.menter;

import com.atlas.menter.entity.Ingredient;
import com.atlas.menter.entity.Recipe;
import com.atlas.menter.entity.User;
import com.atlas.menter.repository.RecipeRepository;
import com.atlas.menter.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@ComponentScan("com.atlas.menter")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner seedDatabase(UserRepository repository){
		return args -> {
			if(!repository.existsByEmail("test123@test.com")){
				User testUser = new User();
				testUser.setUsername("test1");
				testUser.setEmail("test123@test.com");
				testUser.setPassword(new BCryptPasswordEncoder().encode("test"));
				testUser.setEnabled(true);
				repository.save(testUser);
			}
//			Ingredient ing = new Ingredient("test", "kg", 123.00);
//			Recipe recipe = new Recipe("test", "Test1 123");
//
//			ing.setRecipe(recipe);
//			Set<Ingredient> ingredients = new HashSet<>();
//			ingredients.add(ing);
//
//			recipe.setIngredients(ingredients);
//			repository.save(recipe);
		};
	}
}
