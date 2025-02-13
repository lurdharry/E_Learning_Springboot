package com.lurdharry.jpa;

import com.lurdharry.jpa.models.Author;
import com.lurdharry.jpa.models.Video;
import com.lurdharry.jpa.repositories.AuthorRepository;
import com.lurdharry.jpa.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

//	@Bean
	public CommandLineRunner commandLineRunner (
			AuthorRepository authorRepository,
			VideoRepository videoRepository
	){
		return args -> {
//				var author = Author.builder()
//						.firstName("Hammed")
//						.lastName("ade")
//						.age(30)
//						.email("ade@gmail.com")
//						.build();
//				authorRepository.save(author);
			var video = Video.builder().name("asdf")
					.length(35)
					.build();
			videoRepository.save(video);
		};
	}

}
