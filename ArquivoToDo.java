import java.lang.reflect.Constructor;

public class ArquivoToDo extends Arquivo<ToDo> {

    public ArquivoToDo(Constructor<ToDo> construtor, String name) throws Exception {
        super(construtor, name);
    }
}
