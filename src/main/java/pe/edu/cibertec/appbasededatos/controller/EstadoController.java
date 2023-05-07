package pe.edu.cibertec.appbasededatos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.cibertec.appbasededatos.model.bd.Estado;
import pe.edu.cibertec.appbasededatos.service.EstadoService;

@Controller
@RequestMapping("/Estado")
public class EstadoController {
	
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping("/frmMantEstado")
	public String frmMantEstado(Model model) {
		model.addAttribute("listaEstado",
				estadoService.listarEstados());
		return "Estado/frmMantEstado";
	}
	
	@GetMapping("/frmRegEstado")
	public String frmRegEstado(Model model) {
		model.addAttribute("estadoForm", 
				new Estado());
		model.addAttribute("visualizar", false);
		return "Estado/frmRegEstado";
	}
	
	@PostMapping("/frmRegEstado")
	public String registrarEstado(
			@ModelAttribute("estadoForm")Estado estado,
			Model model) {
		String mensaje = "Estado registrado correctamente";
		try {
			estadoService.registrarEstado(estado);
		}catch (Exception e) {
			mensaje ="Estado no registrado";
		}
		model.addAttribute("estadoForm", new Estado());
		model.addAttribute("visualizar", true);
		model.addAttribute("respuesta", mensaje);
		return "Estado/frmRegEstado";
	}
	
	

}
