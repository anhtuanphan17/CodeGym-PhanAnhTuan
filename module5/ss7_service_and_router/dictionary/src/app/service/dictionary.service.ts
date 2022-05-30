import {Injectable} from '@angular/core';
import {Dictionary} from '../model/dictionary';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  dictionaries: Array<Dictionary> = [
    {id: 1, englishWord: 'green', vietnameseWord: 'xanh lá'},
    {id: 2, englishWord: 'blue', vietnameseWord: 'xanh biển'},
    {id: 3, englishWord: 'orange', vietnameseWord: 'cam'},
    {id: 4, englishWord: 'red', vietnameseWord: 'đỏ'},
    {id: 5, englishWord: 'white', vietnameseWord: 'trắng'}
  ];

  constructor() {
  }

  findById(id: number) {
    for (const dictionary of this.dictionaries) {
      if (dictionary.id === id) {
        return dictionary;
      }
    }
  }
}
