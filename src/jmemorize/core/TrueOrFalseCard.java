/*
 * jMemorize - Learning made easy (and fun) - A Leitner flashcards tool
 * Copyright(C) 2004-2008 Riad Djemili and contributors
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 1, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */
package jmemorize.core;

import java.util.Date;

/**
 * A flash card that has a front/flip side and can be learned.
 *
 * @author djemili
 * @version $Id: Card.java 1048 2008-01-21 21:40:00Z djemili $
 */
public class TrueOrFalseCard {
    public static final long    ONE_DAY     = 1000L * 60L * 60L * 24L;
    public static final boolean CLONE_DATES = Main.isDevel();

    private Category m_category;
    private int      m_level;

    // content
    private CardSide m_frontSide = new CardSide();
    private CardSide m_backSide  = new CardSide();

    // dates
    private Date m_dateTested;
    private Date     m_dateExpired;
    private Date     m_dateCreated;
    private Date     m_dateModified;
    private Date     m_dateTouched; //this date is used internaly to order cards

    // stats
    private int      m_testsTotal;
    private int      m_testsHit;    //succesfull learn repetitions
    private int      m_frontHitsCorrect;
    private int      m_backHitsCorrect;


    private String status;

    public void setTrueStatus(String status){

        status="True";
        this.status = status ;
    }
    public void setFalseStatus(String status){

        status="False";
        this.status = status ;
    }


    private Date cloneDate(Date date)
    {
        if (CLONE_DATES)
        {
            return date == null ? null : (Date)date.clone();
        }

        return date;
    }
    public int getLearnedAmount(boolean frontside)
    {

        return frontside ? m_frontHitsCorrect : m_backHitsCorrect;
    }


}

