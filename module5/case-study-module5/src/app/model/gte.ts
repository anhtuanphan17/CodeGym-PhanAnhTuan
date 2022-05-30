import {AbstractControl, ValidationErrors} from '@angular/forms';

export function gte(control: AbstractControl): ValidationErrors | null {
  {
    const value = control.value;

    if (isNaN(value)) {
      return {gte: true, requiredValue: 'Must be a number'};
    }

    if (value < 0) {
      return {gte: true, requiredValue: 'Must be greate than 0'};
    }

    return null;

  }
}
