package bookmarks;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import java.util.List;

public class Query implements GraphQLQueryResolver{
	
	private final BookmarkRepository bookmarkRepository;
	
	public Query(BookmarkRepository bookmarkRepository){
		
		this.bookmarkRepository = bookmarkRepository;

	}
	
	public List<Bookmark> bookmarks(String username){
		
		return bookmarkRepository.findByAccountUsername(username);
		
	}
	
}