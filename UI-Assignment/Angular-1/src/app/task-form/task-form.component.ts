import { Component, Injectable, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { Task } from '../task-model/task-Model';
import { TaskModelService } from '../task-model/task-model.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-task-form',
  templateUrl: './task-form.component.html',
  styleUrls: ['./task-form.component.css']
})

export class TaskFormComponent implements OnInit {
  taskForm: FormGroup;
  submitted = false;
  taskModel:Task;

  constructor(private fb: FormBuilder, private taskService: TaskModelService,
    private router: Router) {

  }
 
  ngOnInit() {
    this.taskForm = this.fb.group({
      taskName: ['', Validators.required],
      taskDescription: ['', Validators.required],
      priority: ['', Validators.required]
    });
  }

  /**
   * Return the value of form. 
   */
  get fval() {
    return this.taskForm.controls;
  }

  /**
   * Method to add task in local storage. 
   */
  addTask() {
    this.submitted = true;
    if (this.taskForm.invalid) {
      return;
    }
    
    this.taskModel=new Task(this.taskForm.value.taskName, 
      this.taskForm.value.taskDescription,
      this.taskForm.value.priority,
      "New", Date.now(), null);

      this.save();  
      this.router.navigate(['/my-task-tracker']) 
  }

  /**
   * save the value on local storage. 
   */
  save() {
    this.taskService.createTask(this.taskModel);
  }
}