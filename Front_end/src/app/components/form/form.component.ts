import { Location } from '@angular/common';
import { Component } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatStepperModule } from '@angular/material/stepper';
import { MatToolbarModule } from '@angular/material/toolbar';
import { FoodServiceService } from '../../services/food-service.service';
import { MatFormFieldModule } from '@angular/material/form-field';
import { ActivatedRoute, Router } from '@angular/router';
import {
  FormBuilder,
  Validators,
  FormsModule,
  ReactiveFormsModule,
  FormControl,
  FormGroup,
} from '@angular/forms';

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [
    FormsModule,
    MatCardModule,
    MatInputModule,
    MatButtonModule,
    MatToolbarModule,
    MatStepperModule,
    MatFormFieldModule,
    ReactiveFormsModule,
  ],
  templateUrl: './form.component.html',
  styleUrl: './form.component.scss',
})
export class FormComponent {
  formGroup!: FormGroup;
  idOfParams!: string | null;

  constructor(
    private router: Router,
    private location: Location,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private service: FoodServiceService
  ) {}

  ngOnInit(): void {
    this.fillOutForm();
  }

  fillOutForm(): void {
    this.route.paramMap.subscribe((params) => {
      this.idOfParams = params.get('id');
    });

    if (this.idOfParams) {
      this.service.getFoodById(this.idOfParams).subscribe((data) => {
        this.formGroup = this.formBuilder.group({
          name: new FormControl(data.name, [
            Validators.required,
            Validators.maxLength(100),
          ]),
          image: new FormControl(data.image),
          price: new FormControl(data.price, [
            Validators.required,
            Validators.min(0),
          ]),
        });
      });
    } else {
      this.formGroup = this.formBuilder.group({
        name: new FormControl('', [
          Validators.required,
          Validators.maxLength(100),
        ]),
        image: new FormControl(''),
        price: new FormControl(0, [Validators.required, Validators.min(0)]),
      });
    }
  }

  submit(): void {
    const first = this.formGroup.value;

    if (!this.idOfParams) {
      this.service
        .postFood(first)
        .subscribe(() => this.router.navigate(['home']));
    } else {
      this.service
        .updateFood(this.idOfParams, first)
        .subscribe(() => this.router.navigate(['home']));
    }
  }

  return(): void {
    this.location.back();
  }
}
