package cjava.servicios;

import java.util.List;

/**
 *
 * @author Net
 */
public interface EntidadService<T> {
    public int crearEntidad(T t);
    public int eliminarEntidad(int codigo);
    public int actualizarEntidad(T t);
    public List<T> obtenerEntidades();
    public T buscarEntidad(int codigo);
}