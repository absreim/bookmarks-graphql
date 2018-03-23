package bookmarks;

import com.coxautodev.graphql.tools.GraphQLResolver;

class BookmarkResolver implements GraphQLResolver<Bookmark>{
	
	public String username(Bookmark bookmark){
		return bookmark.getAccount().getUsername();
	}
	
}