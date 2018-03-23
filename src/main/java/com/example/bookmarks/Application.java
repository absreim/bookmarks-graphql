package bookmarks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import graphql.schema.GraphQLSchema;
import com.coxautodev.graphql.tools.SchemaParser;
import com.coxautodev.graphql.tools.SchemaParserBuilder;
import java.util.Arrays;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	GraphQLSchema schema(BookmarkRepository bookmarkRepository){
		
		SchemaParserBuilder builder = SchemaParser.newParser();
		builder.file("bookmarks.graphqls");
		builder.resolvers(new Query(bookmarkRepository), new BookmarkResolver());
		return builder.build().makeExecutableSchema();
		
	}

}