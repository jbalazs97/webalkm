package hu.me.iit.webalk.first;

import java.util.List;

public interface ArticleRepository   {
	
	List<ArticleDto>findAll();
	ArticleDto getById(Long id);
    Long save();
	void deleteById(Long id);
	Long save(ArticleDto articleDto);

}
