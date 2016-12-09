/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.AvailableBet;
import interfaces.BetType;
import interfaces.Match;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import utilities.GeneralHelper;

/**
 *
 * @author Rypon
 */
public class DetailsTableModel extends DefaultTableModel implements TableModel {

    private ArrayList<Match> matches;
    private ArrayList<String> headers;
    private GeneralHelper helper;
    private String[] betOdds = {"Rate", "Home", "Away"};

    public DetailsTableModel(ArrayList<Match> matches) {
        this.matches = matches;
    }    
    
    private void initHeaders() {
        headers = new ArrayList<>();
        headers.add("ID");
        headers.add("Time");
        headers.add("League");
        headers.add("Home Team");
        headers.add("Fav");
        headers.add("");
        headers.add("");
        headers.add("Fav");
        headers.add("Away Team");
        for (AvailableBet avbet : matches.get(0).getBets()) {
            for (BetType type : avbet.getBets()) {
                for (String str : betOdds) {
                    try {
                        type.getClass().getMethod("get" + str);
                        headers.add(avbet.getName() + " - " + type.getName() + " - " + str);
                    } catch (NoSuchMethodException ex) {
                        helper.setLog("No such method found: get" + str);
                    } catch (SecurityException ex) {
                        helper.setLog("Security exception for accessing method: get" + str);
                    }
                }
            }
        }
    }

    @Override
    public int getRowCount() {
        return matches.size();
    }

    @Override
    public int getColumnCount() {
        return headers.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return headers.get(columnIndex);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 4 || columnIndex == 7) {
            return JCheckBox.class;
        } else {
            return String.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (matches.size() > 0) {
            switch (columnIndex) {
                case 0:
                    return matches.get(rowIndex).getId();
                case 1:
                    return matches.get(rowIndex).getTime();
                case 2:
                    return matches.get(rowIndex).getLeague().toString();
                case 3:
                    return matches.get(rowIndex).getHomeName().toString();
                case 4:
                    JCheckBox cbh = new JCheckBox();
                    if (matches.get(rowIndex).getFavourite().equals(matches.get(rowIndex).getHomeName())) {
                        cbh.setSelected(true);
                    }
                    return cbh;
                case 5:
                    return matches.get(rowIndex).getScore().get(matches.get(rowIndex).getHomeName()).toString();
                case 6:
                    return matches.get(rowIndex).getScore().get(matches.get(rowIndex).getAwayName()).toString();
                case 7:
                    JCheckBox cba = new JCheckBox();
                    if (matches.get(rowIndex).getFavourite().equals(matches.get(rowIndex).getAwayName())) {
                        cba.setSelected(true);
                    }
                    return cba;
                case 8:
                    return matches.get(rowIndex).getAwayName().toString();
                default:
                    return getOdds(matches.get(rowIndex), columnIndex - 9);
            }
        } else {
            return null;
        }
    }

    private float getOdds(Match match, int index) {
        int count = 0;
        for (AvailableBet avbet : match.getBets()) {
            for (BetType type : avbet.getBets()) {
                for (String str : betOdds) {
                    try {
                        Method method = type.getClass().getMethod("get" + str);
                        try {
                            if (index == count) {
                                return (float) method.invoke(type);
                            }
                            count++;
                        } catch (IllegalAccessException ex) {
                            helper.setLog("Illegal Access Invoking Method: get" + str);
                        } catch (IllegalArgumentException ex) {
                            helper.setLog("Illegal Argument Invoking Method: get" + str);
                        } catch (InvocationTargetException ex) {
                            helper.setLog("Invocation Target Invoking Method: get" + str);
                        }
                    } catch (NoSuchMethodException ex) {
                        helper.setLog("No such method found: get" + str);
                    } catch (SecurityException ex) {
                        helper.setLog("Security exception for accessing method: get" + str);
                    }
                }
            }
        }
        return 0;
    }
}
