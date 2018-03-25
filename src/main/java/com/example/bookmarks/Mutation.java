package bookmarks;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import java.util.Optional;

class Mutation implements GraphQLMutationResolver{

	private final AccountRepository accountRepository;
	private final BookmarkRepository bookmarkRepository;
	
	public Mutation(AccountRepository accountRepository, BookmarkRepository bookmarkRepository){
		this.accountRepository = accountRepository;
		this.bookmarkRepository = bookmarkRepository;
	}
	
	public String createUser(String username){
		
		Optional<Account> potentialAcct = accountRepository.findByUsername(username);
		if(potentialAcct.isPresent()){
			return "User already exists.";
		}
		else{
			try{
				accountRepository.save(new Account(username,"password"));
				return "Account successfully created.";
			}
			catch(RuntimeException e){
				return "An error has occurred. Account may not have been created successfully.";
			}
		}
		
	}
	
	public String addBookmark(String username, String uri, String description){
		
		Optional<Account> potentialAcct = accountRepository.findByUsername(username);
		if(potentialAcct.isPresent()){
			try{
				bookmarkRepository.save(new Bookmark(potentialAcct.get(), uri, description));
				return "Bookmark created successfully.";
			}
			catch(RuntimeException e){
				return "An error has occurred. Bookmark may not been created successfully.";
			}
		}
		else{
			return "User does not exist.";
		}
		
	}

}