package com.nhlstenden.JabberPoint.ControllerManagement;

import com.nhlstenden.JabberPoint.LoaderManagement.Accessor;
import com.nhlstenden.JabberPoint.LoaderManagement.XMLAccessor;
import com.nhlstenden.JabberPoint.PresentationManagement.Presentation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class FileCommand implements Command {
  private final Presentation presentation;
  private final JFrame parentFrame;

  // Constructor
  public FileCommand(Presentation presentation, JFrame parentFrame) {
    this.presentation = presentation;
    this.parentFrame = parentFrame;
  }

  @Override
  public void execute() {

    JMenuItem openMenuItem = new JMenuItem("Open");
    JMenuItem newMenuItem = new JMenuItem("New");
    JMenuItem saveMenuItem = new JMenuItem("Save");
    JMenuItem exitMenuItem = new JMenuItem("Exit");

    openMenuItem.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            openFile();
          }
        });

    newMenuItem.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            presentation.clear();
          }
        });

    saveMenuItem.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            saveFile();
          }
        });

    exitMenuItem.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            presentation.exit(0);
          }
        });

    JMenu fileMenu = new JMenu("File");
    fileMenu.add(openMenuItem);
    fileMenu.add(newMenuItem);
    fileMenu.add(saveMenuItem);
    fileMenu.addSeparator();
    fileMenu.add(exitMenuItem);

    // Display File menu
    JMenuBar menuBar = new JMenuBar();
    menuBar.add(fileMenu);
    parentFrame.setJMenuBar(menuBar);
  }

  // Method to open a file
  protected void openFile() {
    JFileChooser fileChooser = new JFileChooser();
    int returnValue = fileChooser.showOpenDialog(parentFrame);
    if (returnValue == JFileChooser.APPROVE_OPTION) {
      try {
        Accessor xmlAccessor = new XMLAccessor();
        xmlAccessor.loadFile(presentation, fileChooser.getSelectedFile());
        presentation.setSlideNumber(0);
      } catch (IOException exc) {
        JOptionPane.showMessageDialog(
            parentFrame,
            "Error opening file: " + exc.getMessage(),
            "Open Error",
            JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  protected void saveFile() {
    JFileChooser fileChooser = new JFileChooser();
    int returnValue = fileChooser.showSaveDialog(parentFrame);
    if (returnValue == JFileChooser.APPROVE_OPTION) {
      try {
        Accessor xmlAccessor = new XMLAccessor();
        xmlAccessor.saveFile(presentation, fileChooser.getSelectedFile());
        JOptionPane.showMessageDialog(
            parentFrame,
            "Presentation saved successfully",
            "Save Successful",
            JOptionPane.INFORMATION_MESSAGE);
      } catch (IOException exc) {
        JOptionPane.showMessageDialog(
            parentFrame,
            "Error saving presentation: " + exc.getMessage(),
            "Save Error",
            JOptionPane.ERROR_MESSAGE);
      }
    }
  }
}
