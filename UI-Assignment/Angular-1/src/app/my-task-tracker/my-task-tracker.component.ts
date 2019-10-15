import { Component, OnInit } from '@angular/core';
import{TaskModelService} from '../task-model/task-model.service'
import { Task } from '../task-model/task-model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-task-tracker',
  templateUrl: './my-task-tracker.component.html',
  styleUrls: ['./my-task-tracker.component.css']
})

export class MyTaskTrackerComponent implements OnInit {

  taskList:Task[];
  task:Task;
  constructor(private taskService: TaskModelService,
    private router: Router ) { }

  ngOnInit() {
    this.taskList = this.taskService.getAllTasks();
  }

}
