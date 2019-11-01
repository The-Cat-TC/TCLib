/*
 * Copyright (C) 2019 the-c
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.tc.cat.the.Test;

import de.tc.cat.the.system.Option;
import de.tc.cat.the.system.Service;
import de.tc.cat.the.system.Status;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author the-c
 */
public class testService {
    
    Service s = new Service("Test",Status.Aktiviert,Option.Run);
    
    @Test
    public void getName()
    {
        assertEquals("Test", s.getName());
    }
    
    @Test
    public void getStatus()
    {
        assertEquals("Aktiviert",s.getStatus());
    }
    
    @Test
    public void getOption()
    {
        assertEquals("Run",s.getOption());
    }
    
    @Test
    public void setOption()
    {
        s.setOption(Option.Stop);
        
        assertEquals(false, s.isRunning());
    }
    
    @Test
    public void setStatus()
    {
        s.setStatus(Status.Deaktiviert);
        
        assertEquals(false, s.isAktiv());
    }
}
