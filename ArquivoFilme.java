import java.lang.reflect.Constructor;

public class ArquivoFilme extends Arquivo<Filme> {

    public ArquivoFilme(Constructor<Filme> construtor, String name) throws Exception {
        super(construtor, name);
    }
}
