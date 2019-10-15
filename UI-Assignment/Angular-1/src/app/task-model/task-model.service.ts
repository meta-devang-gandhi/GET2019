import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { generateGuid } from './generateGuid';
import { Task } from './task-model';

@Injectable({
    providedIn: 'root'
})
export class TaskModelService {
  
    taskList: Task[] = [];
    obj: JSON;
    task1: Task;
    taskTemp: Task;
  
    taskUrl = "http://localhost:8080/tasks";
    constructor(private http: HttpClient) { }
  
  /**
   * Method to fatch task from local storage. 
   */
    getAllTasks() {
        this.taskList = [];
        for (let key in localStorage) {
            if (localStorage.getItem(String(key)) != null) {
                this.taskTemp = this.stringToTask(localStorage.getItem(String(key)));
                this.taskList.push(this.taskTemp);
            }
        }
        localStorage.key
        return this.taskList;
    }

    /**
     * Method to convert string to task.
     * @param str 
     */
    stringToTask(str: string) {
        var tempStr = str.split(",");

        if (tempStr[5] == "null") {
            this.task1 = new Task(String(tempStr[0]), String(tempStr[1]),
                String(tempStr[2]), String(tempStr[3]), tempStr[4], null);
        }
        else {
            this.task1 = new Task(String(tempStr[0]), String(tempStr[1]),
                String(tempStr[2]), String(tempStr[3]), tempStr[4], tempStr[5]);
        }
        
        return this.task1;
    }

    /**
     * Method to create task.
     * @param task 
     */
    createTask(task: Task) {
        var gen = generateGuid.newGuid();
        var json = this.taskToString(task);
        localStorage.setItem(String(gen), json);
        console.log(gen);
    }

    /**
     * Method to convert task to string. 
     * @param task 
     */
    taskToString(task: Task) {
        var tTs = task.taskName + ','
            + task.taskDescription + ',' + task.taskPriority
            + ',' + task.status + ',' + task.creationDate
            + ',' + task.completionDate;

        return tTs;
    }

    /**
     * Method to update task.
     * @param task 
     */
    updateTask(task: Task) {
        for (let key in localStorage) {
            if (localStorage.getItem(String(key)) != null) {
                if (localStorage.getItem(String(key)).split(",")[4] == String(task.creationDate)) {
                    localStorage.setItem(String(key), this.taskToString(task));
                }
            }
        }
    }
    
    /**
     * Method to delete task.
     */
    deleteTask(task: Task) {
        for (let key in localStorage) {
            if (localStorage.getItem(String(key)) != null) {
                if (localStorage.getItem(String(key)).split(",")[4] == String(task.creationDate)) {
                    localStorage.removeItem(String(key));
                }
            }
        }
    }
}
