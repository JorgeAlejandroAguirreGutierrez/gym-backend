package com.backend.gym.servicios;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.backend.gym.Constantes;
import com.backend.gym.Util;
import com.backend.gym.exception.ModeloExistenteException;
import com.backend.gym.exception.ModeloNoExistenteException;
import com.backend.gym.modelos.Perfil;
import com.backend.gym.modelos.Usuario;
import com.backend.gym.repositorios.IPerfilRepository;
import com.backend.gym.repositorios.IUsuarioRepository;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import static com.backend.gym.Constantes.PERFILCLIENTE;
import static com.backend.gym.Constantes.PERFILADMIN;
import static com.backend.gym.Constantes.LOGCLASS;
import static com.backend.gym.Constantes.LOGMETHOD;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.persistence.criteria.Predicate;

@Service
public class UsuarioService {
	private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private IUsuarioRepository usuarioRepository;
    
    @Autowired
    private IPerfilRepository perfilRepository;
    
    @Autowired 
    private Environment environment;

    /**
     * Consulta el cliente por id
     * @param id
     * @return Cliente
     */
    public Optional<Usuario> obtener(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final Optional<Usuario> usuario= usuarioRepository.findById(id);
        return usuario;
    }
    /**
     * Consulta todos los clientes
     * @return List<Usuario>
     */
    public List<Usuario> consultar() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }
    /**
     * Crea un nuevo cliente
     * @param Usuario
     * @return Usuario 
     */
    public Optional<Usuario> crear(Usuario usuario) {
    	Optional<Usuario> usuarioExiste=usuarioRepository.buscarIdentificacion(usuario.getIdentificacion());
    	if (usuarioExiste.isPresent()) {
    		throw new ModeloExistenteException();
    	}
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(usuarioRepository.save(usuario));
    }
    /**
     * Actualiza un usuario
     * @param Usuario
     * @return Optional<Usuario>
     */
    public Optional<Usuario> actualizar(Usuario usuario) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(usuarioRepository.save(usuario));
    }
    
    /**
     * Elimina un cliente
     * @param id
     */
    public void eliminar(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	usuarioRepository.deleteById(id);
    }
    
    /**
     * Consulta los usuarios por nombre o deintificacion
     * @return List<Usuario>
     */
    public List<Usuario> consultarClientesPorNombreIdentificacion(String nombre, String identificacion) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return  usuarioRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
		    List<Predicate> predicates = new ArrayList<>();
		    if (nombre!=null && !nombre.equals("")) {
		        predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("nombre"), "%"+nombre+"%")));
		    }
		    if (identificacion!=null && !identificacion.equals("")) {
		        predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("identificacion"), "%"+identificacion+"%")));
		    }
		    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("perfil").get("descripcion"), Constantes.PERFILCLIENTE)));
		    return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		});
    }
    
    /**
     * Consulta los usuarios que tienes perfil CLIENTE
     * @return List<Usuario>
     */
    public List<Usuario> consultarClientes() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return  usuarioRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
		    List<Predicate> predicates = new ArrayList<>();
		    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("perfil").get("descripcion"), Constantes.PERFILCLIENTE)));
		    return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		});
    }
    
    /**
     * Consulta los usuarios que tienes perfil ADMIN
     * @return List<Usuario>
     */
    public List<Usuario> consultarAdmins() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return  usuarioRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
		    List<Predicate> predicates = new ArrayList<>();
		    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("perfil").get("descripcion"), Constantes.PERFILADMIN)));
		    return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		});
    }
    
    /**
     * Obtiene el  usuario por la identificacion
     * @return Optional<Usuario>
     */
    public Optional<Usuario> obtenerPorIdentificacion(String identificacion) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return  usuarioRepository.findOne((root, criteriaQuery, criteriaBuilder) -> {
		    List<Predicate> predicates = new ArrayList<>();
		    if (identificacion!=null) {
		        predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("identificacion"), identificacion)));
		    }
		    return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		});
    }
    
    /**
     * Crea un nuevo cliente
     * @param Usuario
     * @return Usuario 
     */
    public Optional<Usuario> crearCliente(Usuario usuario) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	Optional<Perfil> perfil= perfilRepository.obtenerPorDescripcion(PERFILCLIENTE);
    	if(perfil.isPresent()) {
    		usuario.setPerfil(perfil.get());
        	String contrasena=Util.generarContrasena(usuario.getIdentificacion());
        	usuario.setContrasena(contrasena);
        	usuario.setActivo(false);
    		return Optional.of(usuarioRepository.save(usuario));
    	}
    	throw new ModeloNoExistenteException();
    }
    
    /**
     * Crea un nuevo Admin
     * @param Usuario
     * @return Usuario 
     */
    public Optional<Usuario> crearAdmin(Usuario usuario) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	Optional<Perfil> perfil= perfilRepository.obtenerPorDescripcion(PERFILADMIN);
    	if(perfil.isPresent()) {
    		usuario.setPerfil(perfil.get());
        	String contrasena=Util.generarContrasena(usuario.getIdentificacion());
        	usuario.setContrasena(contrasena);
        	usuario.setActivo(true);
    		return Optional.of(usuarioRepository.save(usuario));
    	}
    	throw new ModeloNoExistenteException();
    }
    
    public ByteArrayInputStream generarPDF(int mes) {
    	try {
    		List<Usuario>usuarios=usuarioRepository.generarPDF(mes);
        	ByteArrayOutputStream salida = new ByteArrayOutputStream();
            PdfWriter writer = new PdfWriter(salida);
            PdfDocument pdf = new PdfDocument(writer);
            // Initialize document
            Document documento = new Document(pdf, PageSize.A4);
            documento.setMargins(20, 20, 20, 20);
            // Add content
            PdfFont font = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
            documento.add(new Paragraph("FACTURA").setFont(font).setFontSize(30));
            documento.add(new Paragraph(environment.getProperty("gym")).setFont(font).setFontSize(30));
            documento.add( new Paragraph("\n"));
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String fechaFormato = formato.format(new Date());
            documento.add(new Paragraph("FECHA REPORTE: "+fechaFormato).setBorder(new SolidBorder(1)));
            documento.add( new Paragraph("\n"));
            documento.add(new Paragraph("MES FACTURADO: "+mes).setBorder(new SolidBorder(1)));
            documento.add( new Paragraph("\n"));
            float [] columnas_tabla = {200F, 200F, 200F};
            Table tabla = new Table(columnas_tabla);
            tabla.addCell("IDENTIFICACION");
            tabla.addCell("NOMBRE");
            tabla.addCell("SUSCRIPCION");
            for (Usuario usuario:usuarios)
            {
                tabla.addCell(usuario.getIdentificacion());
                tabla.addCell(usuario.getNombre());
                String fecha = formato.format(usuario.getSuscripciones().get(usuario.getSuscripciones().size()-1).getFecha());
                tabla.addCell(fecha);
            }
            documento.add(tabla);
            documento.add( new Paragraph("\n"));
            int total= usuarios.size()*Integer.parseInt(environment.getProperty("comision"));
            documento.add(new Paragraph("TOTAL: "+total).setBorder(new SolidBorder(1)));
            documento.add(new Paragraph(
                    Constantes.CUENTAAHORROS+environment.getProperty("cuenta")).setBorder(new SolidBorder(1)));
            // 5. Close document
            documento.close();
            return new ByteArrayInputStream(salida.toByteArray());
    	}catch(Exception e) {
    		return null;
    	}
    	
    }
}
