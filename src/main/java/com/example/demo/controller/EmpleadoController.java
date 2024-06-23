package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.AreaEntity;
import com.example.demo.entity.EmpleadoEntity;
import com.example.demo.repository.AreaRepository;
import com.example.demo.repository.EmpleadoRepository;

@Controller
public class EmpleadoController {
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	@Autowired
	private AreaRepository areaRepository;
	
	//Listado
	 @GetMapping("/listar")
	    public String listarEmpleados(Model model) {
	        List<EmpleadoEntity>listaEmpleados = empleadoRepository.findAll();
	        model.addAttribute("listaEmpleados", listaEmpleados);
	        return "inicio";
	    }
	
	//Crear
	 @GetMapping("/registrar_empleado")
	    public String showRegistrarEmpleado(Model model) {
	        List<AreaEntity>listaArea = areaRepository.findAll();
	        model.addAttribute("listaArea", listaArea);
	        model.addAttribute("empleado", new EmpleadoEntity());
	        return "registrar";
	    }

	    @PostMapping("/registrar_empleado")
	    public String registrarEmpleado(Model model, @ModelAttribute EmpleadoEntity empleado, RedirectAttributes redirectAttributes) {
	    	empleadoRepository.save(empleado);
	    	
	   
	    	
	        return "redirect:/listar";
	    }
	
	    
	//Detalle
	    @GetMapping("/detalle_empleado/{dni}")
		public String verEmpleado(Model model , @PathVariable("dni")String dni) {
			List<AreaEntity> listaArea = areaRepository.findAll();
			EmpleadoEntity empleadoEncontrado = empleadoRepository.findByDniE(dni);
			 model.addAttribute("empleado",empleadoEncontrado);
			return "detalle";
		}
		
	    
	//Actualizar
	
	    @GetMapping("/actualizar_empleado{dni}")
	    public String actualizarEmpleado(Model model, @PathVariable("dni") String dni) {
	        EmpleadoEntity empleado = empleadoRepository.findByDni(dni);
	        List<AreaEntity> listaArea = areaRepository.findAll();
	    
	        model.addAttribute("listaArea", listaArea);
	        model.addAttribute("empleado", empleado);
	        return "actualizar";
	    }

	    @PostMapping("/actualizar_empleado")
	    public String actualizarEmpleado(@ModelAttribute EmpleadoEntity empleado, RedirectAttributes redirectAttributes) {
	        empleadoRepository.save(empleado);
	        
	
	        
	        return "redirect:/listar";
	    }

	
	//Eliminar	
	    @GetMapping("/eliminar_empleado/{dni}")
	    public String eliminarEmpleado(@PathVariable("dni") String dni) {
	        empleadoRepository.deleteById(dni);
	        return "redirect:/listar";
	    }
}
