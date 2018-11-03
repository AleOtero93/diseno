import java.io.StringWriter;

import entidades.Categoria;
import entidades.Cliente;
import entidades.TipoDocumento;

public class TestHtml {

	public static void main(String[] args) {
		MustacheFactory mf = new DefaultMustacheFactory();
		Mustache m = mf.compile("testeo.mustache");
		
		Cliente ale = new Cliente("Alejandro","Otero","usuario","password","Casa",102.25,114.30,TipoDocumento.DNI,37837378,new Categoria("TestCat",1,2,1f,2f));
		StringWriter writer = new StringWriter();
		m.execute(writer, ale).flush();
		String html = writer.toString();
	}

}
