import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ApiService } from '../api.service';
import { Person } from '../person';
@Component({
  selector: 'app-add-person',
  templateUrl: './add-person.component.html',
  styleUrls: ['./add-person.component.css']
})
export class AddPersonComponent implements OnInit {

  personForm: FormGroup;
  constructor(private formBuilder: FormBuilder, private router: Router, private api: ApiService) {}
 
 
  ngOnInit() {
    this.personForm = this.formBuilder.group({
      personFirstName: ['', [Validators.required]],
      personSecondName: ['', [Validators.required]],
      personThirdName: ['', [Validators.required]],
      personFamilyName: ['', [Validators.required]],

      personEmail: ['', [Validators.required]],
      personSex: ['0', [Validators.required]],
      personStatus: ['0', [Validators.required]],
      personBirthdate: ['', [Validators.required]],
      personIdType: ['0', [Validators.required]],
      personIdNo: ['', [Validators.required]],
      personMobile: ['', [Validators.required]],
      personAddress: ['', [Validators.required]]

    });
  }
 
  addPerson() {
    let person : Person = new Person(null,
      this.personForm.get('personFirstName').value,
      this.personForm.get('personSecondName').value,
      this.personForm.get('personThirdName').value,
      this.personForm.get('personFamilyName').value,

      this.personForm.get('personSex').value,
    this.personForm.get('personStatus').value,
    this.personForm.get('personBirthdate').value,
    this.personForm.get('personIdType').value,
    this.personForm.get('personIdNo').value,
    this.personForm.get('personMobile').value,
    this.personForm.get('personEmail').value,
    this.personForm.get('personAddress').value);




    this.api.addPerson(person).subscribe( (res:Person) => { 
      this.router.navigate(['/person']);
        }, (err) => {
          console.log(err);
        });
  }

}
