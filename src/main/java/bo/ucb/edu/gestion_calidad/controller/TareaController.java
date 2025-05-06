package bo.ucb.edu.gestion_calidad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import bo.ucb.edu.gestion_calidad.model.Tarea;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class TareaController {

    private final List<Tarea> tareas = new ArrayList<>();
    private final AtomicInteger contador = new AtomicInteger();

    @GetMapping("/")
    public String verTareas(Model model) {
        model.addAttribute("tareas", tareas);
        return "tareas";
    }

    @PostMapping("/agregar")
    public String agregarTarea(@RequestParam String descripcion) {
        int id = contador.incrementAndGet();
        tareas.add(new Tarea(id, descripcion));
        return "redirect:/";
    }

    @PostMapping("/eliminar")
    public String eliminarTarea(@RequestParam int id) {
        Iterator<Tarea> iterator = tareas.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                break;
            }
        }
        return "redirect:/";
    }

    @PostMapping("/mover-arriba")
    public String moverArriba(@RequestParam int id) {
        for (int i = 1; i < tareas.size(); i++) {
            if (tareas.get(i).getId() == id) {
                Tarea temp = tareas.get(i - 1);
                tareas.set(i - 1, tareas.get(i));
                tareas.set(i, temp);
                break;
            }
        }
        return "redirect:/";
    }

    @PostMapping("/mover-abajo")
    public String moverAbajo(@RequestParam int id) {
        for (int i = 0; i < tareas.size() - 1; i++) {
            if (tareas.get(i).getId() == id) {
                Tarea temp = tareas.get(i + 1);
                tareas.set(i + 1, tareas.get(i));
                tareas.set(i, temp);
                break;
            }
        }
        return "redirect:/";
    }

    @PostMapping("/modificar")
    public String modificarTarea(@RequestParam int id, @RequestParam String descripcion) {
        for (Tarea tarea : tareas) {
            if (tarea.getId() == id) {
                tarea.setDescripcion(descripcion);
                break;
            }
        }
        return "redirect:/";
    }
}