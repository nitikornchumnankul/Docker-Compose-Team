import { Component, OnInit, ViewChild } from '@angular/core';
import { StudentService } from '../student.service';
import { MatTableDataSource, MatPaginator } from '@angular/material';
export interface student {  
  id:number,
  nametitle:string,
  firstname:string,
  lastname:string,
  studentId:string,
}
@Component({
  selector: 'app-member-list',
  templateUrl: './member-list.component.html',
  styleUrls: ['./member-list.component.css']
})
export class MemberListComponent implements OnInit {

  @ViewChild(MatPaginator) paginator: MatPaginator;
  constructor(private studentService: StudentService) { }
  memberList;
  dataSource:any;
  displayedColumns: string[] = ['id','nametitle', 'firstname','lastname', 'studentId'];
  ngOnInit() {
    this.getmemberList();
  }

  getmemberList(){
    this.studentService.getList().subscribe(data => {
      this.memberList = data;
      console.log(data)
      const studentList: student[] = [];
      for (let index = 0; index < this.memberList["length"]; index++) {
        studentList.push({
          id: this.memberList[index].id,
          nametitle:this.memberList[index].nametitle,
          firstname: this.memberList[index].firstname,
          lastname:this.memberList[index].lastname,
          studentId: this.memberList[index].cardid,
        })
        }  
        this.dataSource = new MatTableDataSource(studentList);
        this.dataSource.paginator = this.paginator;
    });
  }
  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}
