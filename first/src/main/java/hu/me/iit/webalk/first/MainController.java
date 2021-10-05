package hu.me.iit.webalk.first;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="article/")

public class MainController {
	
	
	private List <ArticleDto> articles =new ArrayList<>();
	

	
	@GetMapping (path= "", produces= MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	
		List<ArticleDto> allArtiles() {
			return articles;
		
	}
	@PostMapping (path= "")
	
	public void newArticle(@RequestBody @Valid ArticleDto articleDto) {
		articles.add(articleDto); }
		
	
	  private int findArticelByID(String id){
	        int found = -1;
	        for (int i=0; i<articles.size(); i++){
	            if (articles.get(i).getTitle().equals(id)){
	                found = i;
	                break;
	            }
	        }
	        return found;
	    }
	
	  @PutMapping(path="/{id}")
	    public void  replaceArticle(@PathVariable("id") String id, @RequestBody @Valid ArticleDto articelDto){

	        int found = findArticelByID(id);

	        if(found != -1){
	            ArticleDto foundArticle = articles.get(found);
	            foundArticle.setAuthor(articelDto.getAuthor());
	            foundArticle.setPages(articelDto.getPages());
	        }

	    }


	@DeleteMapping (path= "{id}")
	public void deleteArticle( @PathVariable ("id") String id) {
		
		int found = -1;
		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getTitle().equals(id)) {
				found = i;
				break;
			}
			
		}
		if (found!=-1) {
			articles.remove(found);
			
		}
	}
	
}
