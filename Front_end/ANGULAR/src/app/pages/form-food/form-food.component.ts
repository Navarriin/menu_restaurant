import { Component } from '@angular/core';
import { FormComponent } from '../../components/form/form.component';

@Component({
  selector: 'app-form-food',
  standalone: true,
  imports: [FormComponent],
  templateUrl: './form-food.component.html',
  styleUrl: './form-food.component.scss'
})
export class FormFoodComponent {

}
