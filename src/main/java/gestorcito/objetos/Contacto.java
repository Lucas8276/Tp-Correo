package gestorcito.objetos;

import java.util.ArrayList;
import java.util.List;

public class Contacto {
    private List<Usuario> listaDeUsuarios;
    public Contacto(){
    listaDeUsuarios= new ArrayList<>();
    }
    public void agrego_Usuario(Usuario  usuario ){
    listaDeUsuarios.add(usuario);
    }
}