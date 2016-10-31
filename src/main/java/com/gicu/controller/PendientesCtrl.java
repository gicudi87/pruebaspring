package com.gicu.controller;



import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gicu.model.Pendientes;
import com.gicu.service.PendientesService;

import antlr.collections.List;

@Controller
public class PendientesCtrl {
	
	
	
	@Autowired
	private PendientesService pendientesService;
	
	
	@RequestMapping(value="/index.do", method = RequestMethod.GET) 
	public String listPendiente(Map<String, Object>map){
		map.put("pendiente", new Pendientes());
		map.put("PendienteList", pendientesService.listPendiente());
		map.put("total", pendientesService.listPendiente().size());
		
		return "home";
		
	}
	
//	public ModelAndView listPendiente(){
//		
//		ModelAndView map = new ModelAndView();
//		
//		
//		map.setViewName("home");
//		map.addObject("PendienteList", pendientesService.listPendiente());
//		map.addObject("pendiente", new Pendientes());
////		map.addObject("total", pendientesService.listPendiente().size());
//		System.out.println("////////////////////////////////////");
//		
//		return map;
//
//		}
//		
//	public String listPendiente(ModelMap map){
//		map.addAttribute("pendiente", new Pendientes());
//		map.addAttribute("PendienteList", pendientesService.listPendiente());
//		map.addAttribute("total", pendientesService.listPendiente().size());
//	return "home";
//	
//}
//	
	
	@RequestMapping(
	value = "/savePendiente",
	method = RequestMethod.POST
	)
	public String addPendiente(@ModelAttribute("pendiente") Pendientes pendientes, BindingResult result){
		
		if(pendientes.getId()>0){
			pendientesService.updatePendiente(pendientes);
		}
		else{
			pendientesService.addPendiente(pendientes);
		}
		return "redirect:/index.do";
	}
	
	
	@RequestMapping("/delete/{pendienteId}")
	public String deletePendiente(
			
			@PathVariable("pendienteId") int pendienteId)
			{
		pendientesService.removePendiente(pendienteId);
		return "redirect:/index.do";
			}
	
	
	@RequestMapping("/edit/{pendienteId}")
	public String editTienda(
			@PathVariable("pendienteId")int pendienteId,
			Map<String, Object>map)
			{
		map.put("pendiente", pendientesService.getPendientesById(pendienteId));
		map.put("PendienteList", pendientesService.listPendiente());
		map.put("total", pendientesService.listPendiente().size());
		return "home";
			}
	

}
