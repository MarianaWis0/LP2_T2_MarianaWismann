package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	    public String showRegistrarProducto(Model model) {
	        List<AreaEntity>listaArea = areaRepository.findAll();
	        model.addAttribute("listaArea", listaArea);
	        model.addAttribute("empleado", new EmpleadoEntity());
	        return "registrar_empleado";
	    }

	    @PostMapping("/registrar_producto")
	    public String registrarProducto(Model model, @ModelAttribute EmpleadoEntity empleado) {
	    	empleadoRepository.save(empleado);
	        return "redirect:/listar";
	    }
	
	//Actualizar
	
	
	
	//Eliminar	

}
