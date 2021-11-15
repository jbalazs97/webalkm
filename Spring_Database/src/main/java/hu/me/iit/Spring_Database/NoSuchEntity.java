package hu.me.iit.Spring_Database;

public class NoSuchEntity {

	private Long id;

    public NoSuchEntity(Long id){
        super("No such entity " +id);
        this.id = id;
    }
}
