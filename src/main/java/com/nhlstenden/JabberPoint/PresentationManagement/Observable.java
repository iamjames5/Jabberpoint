package com.nhlstenden.JabberPoint.PresentationManagement;

public interface Observable {
  void addObserver(Observer observer);

  void removeObserver(Observer observer);

  void notifyObservers();
}
