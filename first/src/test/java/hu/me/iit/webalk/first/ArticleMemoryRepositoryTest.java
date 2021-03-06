package hu.me.iit.webalk.first;

import hu.me.iit.webalk.first.ArticleDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArticleMemoryRepositoryTest {

    @Test
    void findAll_Empty() {
        //GIVEN
        ArticleMemoryRepository articleMemoryRepository = new ArticleMemoryRepository();

        //WHEN
        List<ArticleDto> result = articleMemoryRepository.findAll();

        //THEN
        assertEquals(0, result.size());
    }

    @Test
    void findAll_NotEmpty() {
        //GIVEN
        ArticleMemoryRepository articleMemoryRepository = new ArticleMemoryRepository();
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(12);
        articleDto.setId(3L);
        articleDto.setTitle("Title");

        articleMemoryRepository.save(articleDto);

        //WHEN
        List<ArticleDto> result = articleMemoryRepository.findAll();

        //THEN
        assertEquals(1, result.size());
        assertEquals(articleDto, result.get(0));
    }

    @Test
    void getById_Exist(){
        //GIVEN
        ArticleMemoryRepository articleMemoryRepository = new ArticleMemoryRepository();
        Long id = 2L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(12);
        articleDto.setId(id);
        articleDto.setTitle("Title");

        articleMemoryRepository.save(articleDto);

        //WHEN
        int result = articleMemoryRepository.findArticleById(id);

        //THEN
        assertEquals(0, result);
    }

    @Test
    void getById_NotExisting(){
        //GIVEN
        ArticleMemoryRepository articleMemoryRepository = new ArticleMemoryRepository();
        Long id = 2L;
        Long notExistingId = 3L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(12);
        articleDto.setId(id);
        articleDto.setTitle("Title");

        articleMemoryRepository.save(articleDto);

        //WHEN
        int result = articleMemoryRepository.findArticleById(notExistingId);

        //THEN
        assertEquals(-1, result);
    }

    @Test
    void getById_NotFound(){
        //GIVEN
        ArticleMemoryRepository articleMemoryRepository = new ArticleMemoryRepository();
        Long id = 2L;
        Long notExistingId = 3L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(12);
        articleDto.setId(id);
        articleDto.setTitle("Title");

        articleMemoryRepository.save(articleDto);

        //WHEN
        int result = articleMemoryRepository.findArticleById(notExistingId);

        //THEN
        assertEquals(-1, result);
    }



    @Test
    void save() {
        //GIVEN
        ArticleMemoryRepository articleMemoryRepository = new ArticleMemoryRepository();
        Long id = 2L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(12);
        articleDto.setId(id);
        articleDto.setTitle("Title");

        articleMemoryRepository.save(articleDto);

        //WHEN
        ArticleDto articleDto2 = new ArticleDto();
        articleDto2.setAuthor("Author");
        articleDto2.setPages(12);
        articleDto2.setId(id);
        articleDto2.setTitle("Title");

        //THEN
        List<ArticleDto> articleDtoList = articleMemoryRepository.findAll();
        assertEquals(1, articleDtoList.size());
        assertEquals(articleDto2, articleDtoList.get(0));
    }

    @Test
    void deleteById_Exists() {
        //GIVEN
        ArticleMemoryRepository articleMemoryRepository = new ArticleMemoryRepository();
        Long id = 2L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(12);
        articleDto.setId(id);
        articleDto.setTitle("Title");

        articleMemoryRepository.save(articleDto);

        //WHEN
        articleMemoryRepository.deleteById(id);

        //THEN
        assertEquals(0, articleMemoryRepository.findAll().size());
    }

    @Test
    void deleteById_NotExists() {
        //GIVEN
        ArticleMemoryRepository articleMemoryRepository = new ArticleMemoryRepository();
        Long id = 2L;
        Long notExistingId = 3L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(12);
        articleDto.setId(id);
        articleDto.setTitle("Title");

        articleMemoryRepository.save(articleDto);

        //WHEN
        articleMemoryRepository.deleteById(notExistingId);

        //THEN
        assertEquals(1, articleMemoryRepository.findAll().size());
    }
} 