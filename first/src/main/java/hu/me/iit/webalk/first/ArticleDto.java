package hu.me.iit.webalk.first;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ArticleDto {
	@NotNull
	@NotBlank
	private String author;
	@NotBlank
	private String title;
	@Min(10)
	private Integer pages;

	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	
	private long Id;
	
	
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	@Override
	public String toString() {
		return "Article [author=" + author + ", title=" + title + ", pages=" + pages + "]";
	}


	
	
	
	

}
