package Controller;

import Dto_Generics.Generic;
//import Model.Painting;
//import Model.Portrait;
//import Model.Sculpture;

abstract class WorkOfArtController {
  //  abstract boolean register(Painting objPainting, Portrait objPortrait, Sculpture objSculpture);
    
    abstract <T> boolean register(Generic objT);

    abstract String search(String titleArtwork);
    
   // abstract boolean update(Painting objPainting, Portrait objPortrait, Sculpture objSculpture);

    abstract <T> boolean update(String titleArtwork, Generic objT);

    abstract boolean remove(String titleArtwork);

    abstract String list();
    
}
