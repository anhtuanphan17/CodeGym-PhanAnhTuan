import {Component, OnInit} from '@angular/core';
import {DictionaryService} from '../service/dictionary.service';
import {Dictionary} from '../model/dictionary';
import {ActivatedRoute, ParamMap} from '@angular/router';

@Component({
  selector: 'app-dictionary-details-page',
  templateUrl: './dictionary-details-page.component.html',
  styleUrls: ['./dictionary-details-page.component.css']
})

export class DictionaryDetailsPageComponent implements OnInit {
  dictionary: Dictionary;
  id: number;

  constructor(private dictionaryService: DictionaryService, private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = Number(paramMap.get('id'));
    });

    if (this.id != null) {
      this.dictionary = dictionaryService.findById(this.id);
      console.log(this.dictionary);
    }
  }

  ngOnInit(): void {
  }

}
