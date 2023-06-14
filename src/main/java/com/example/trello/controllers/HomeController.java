package com.example.trello.controllers;


import com.example.trello.classes.Folders;
import com.example.trello.classes.Status;
import com.example.trello.classes.TaskCats;
import com.example.trello.classes.Tasks;
import com.example.trello.repos.StatusRepos;
import com.example.trello.services.FolderService;
import com.example.trello.services.TaskCatService;
import com.example.trello.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final FolderService folderService;
    private final TaskService taskService;
    private final TaskCatService taskCatService;
    private final StatusRepos statusRepos;
    @GetMapping(value = "/")
    public String indexPage(Model model){
        List<Folders> folders = folderService.getAllFolder();
        model.addAttribute("folders", folders);
        return "index";
    }
    @PostMapping(value = "/addFolder")
    public String addFolder(Folders folders){
        folderService.addFolder(folders);
        return "redirect:/";
    }
    @GetMapping(value = "folderDet/{folderId}")
    public String folderDet(@PathVariable(name = "folderId") Long id, Model model){
        Folders folder = folderService.getFolderById(id);
        List<Tasks> tasks = taskService.getTaskByFolderId(id);
        List<TaskCats> taskCatsList = taskCatService.getListOfCategories();
        taskCatsList.removeAll(folder.getCategories());
        List<Status> statusList = statusRepos.findAll();
        model.addAttribute("categories", taskCatsList);
        model.addAttribute("status", statusList);
        model.addAttribute("folder",folder);
        model.addAttribute("tasks",tasks);
        return "folderDets";
    }
    @PostMapping(value = "/addTask")
    public String addTask(Tasks tasks){
        Long folderId = tasks.getFolders().getId();
        taskService.addTask(tasks);
        return "redirect:/folderDet/" + folderId;
    }
    @GetMapping(value = "/taskDet/{task_id}")
    public String taskDet(@PathVariable(name = "task_id") Long id,Model model){
        Tasks tasks = taskService.getTaskById(id);
        List<Status> status = statusRepos.findAll();
        model.addAttribute("status", status);
        model.addAttribute("task",tasks);
        return "taskDets";
    }

    @PostMapping(value = "/assCat")
    public String assignCat(@RequestParam(name = "folderId") Long folderId,
                            @RequestParam(name = "catId") Long catId){
        taskCatService.assignCategory(folderId,catId);
        return "redirect:/folderDet/" + folderId;
    }
    @PostMapping(value = "unCat")
    public String unassignCat(@RequestParam(name = "folderId") Long folderId,
                              @RequestParam(name = "catId") Long catId){
        taskCatService.unassignCategory(folderId,catId);
        return "redirect:/folderDet/" + folderId;
    }

    @GetMapping(value = "/categories")
    public String categories(Model model){
        List<TaskCats> taskCatsList = taskCatService.getListOfCategories();
        model.addAttribute("categories", taskCatsList);
        return "categories";
    }
    @PostMapping(value = "/addCats")
    public String addCat(TaskCats taskCats, @RequestParam(name = "folderId") Long id){
        taskCatService.addCategory(taskCats);
        return "redirect:/folderDet/" + id;
    }
    @PostMapping(value = "/addCatCat")
    public String addCatCat(TaskCats taskCats){
        taskCatService.addCategory(taskCats);
        return "redirect:/categories";
    }
    @PostMapping(value = "/updTask")
    public String updTask(Tasks tasks){
        taskService.updTask(tasks);
        return "redirect:/folderDet/" + tasks.getFolders().getId();
    }
    @PostMapping(value = "/deleteFolder")
    public String deleteFolder(@RequestParam(name = "folderId") Long folderId){
        folderService.deleteFolder(folderId);
        return "redirect:/";
    }
    @PostMapping(value = "/deleteTask")
    public String deleteTask(@RequestParam(name = "taskId") Long taskId,
                             @RequestParam(name = "folderId")Long folderId){
        taskService.deleteTask(taskId);
        return "redirect:/folderDet/" + folderId;
    }
    @PostMapping(value = "/deleteCats")
    public String deleteCats(@RequestParam(name = "catId") Long id){
        taskCatService.deleteCategoryById(id);
        return "redirect:/categories";
    }
}
