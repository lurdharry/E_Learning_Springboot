package com.lurdharry.jpa;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakerIDN;
import com.lurdharry.jpa.models.Author;
import com.lurdharry.jpa.models.Video;
import com.lurdharry.jpa.repositories.AuthorRepository;
import com.lurdharry.jpa.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;
import specifications.AuthorSpecification;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (
			AuthorRepository authorRepository,
			VideoRepository videoRepository
	){
		return args -> {

//			for (int i = 0; i < 50; i++) {
//				Faker faker = new Faker();
//				var author = Author.builder()
//						.firstName(faker.name().firstName())
//						.lastName(faker.name().lastName())
//						.age(faker.number().numberBetween(19,50 ))
//						.email("ade"+ i +"@gmail.com")
//						.build();
//				authorRepository.save(author);
//			}

		/*	var video = Video.builder().name("asdf")
					.length(35)
					.build();
			videoRepository.save(video);*/

//			authorRepository.updateAuthor(100,1);

//			authorRepository.updateAllAuthorAge(100);
//
//		  authorRepository.findByNamedQuery(12).stream().forEach(System.out::println);
			Specification<Author> specification = Specification
					.where(AuthorSpecification.hasAge(34))
					.and(AuthorSpecification.firstNameContains("ad"));

			authorRepository.findAll(specification).forEach(System.out::println);
		};
	}

}
