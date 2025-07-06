import java.util.ArrayList;
import java.util.List;

public class TablaReg {
	
	public Regla[][] reg = new Regla[AnalizadorSintactico.simbolosNoTerminales.values().length]
			[AnalizadorSintactico.simbolosTerminales.values().length];
	public TablaReg() {
		List<AnalizadorSintactico.simbolos> l;
		
		for (int i = 0; i < reg.length; i++) {
		    for (int j = 0; j < reg[i].length; j++) {
		        reg[i][j] = null;
		    }
		}
		
		int i = 1;
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.uno);
		l.add(AnalizadorSintactico.simbolos.P);
		Regla r1 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.dos);
		l.add(AnalizadorSintactico.simbolos.P);
		l.add(AnalizadorSintactico.simbolos.B);
		Regla r2 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.dos);
		l.add(AnalizadorSintactico.simbolos.P);
		l.add(AnalizadorSintactico.simbolos.F);
		Regla r3 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.uno);
		l.add(AnalizadorSintactico.simbolos.eof);
		Regla r4 = new Regla(l,i++);
		
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.cuatro);
		l.add(AnalizadorSintactico.simbolos.puntComa);
		l.add(AnalizadorSintactico.simbolos.once);
		l.add(AnalizadorSintactico.simbolos.id);
		l.add(AnalizadorSintactico.simbolos.T);
		l.add(AnalizadorSintactico.simbolos.var);
		l.add(AnalizadorSintactico.simbolos.tres);
		Regla r5 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.cinco);
		l.add(AnalizadorSintactico.simbolos.Z);
		l.add(AnalizadorSintactico.simbolos.cierraPar);
		l.add(AnalizadorSintactico.simbolos.E);
		l.add(AnalizadorSintactico.simbolos.abrePar);
		l.add(AnalizadorSintactico.simbolos.ifS);
		Regla r6 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.seis);
		l.add(AnalizadorSintactico.simbolos.S);
		Regla r7 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.seis);
		l.add(AnalizadorSintactico.simbolos.S);
		Regla r8 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.siete);
		l.add(AnalizadorSintactico.simbolos.Y);
		l.add(AnalizadorSintactico.simbolos.cierraLlav);
		l.add(AnalizadorSintactico.simbolos.C);
		l.add(AnalizadorSintactico.simbolos.abreLlav);
		Regla r9 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.ocho);
		l.add(AnalizadorSintactico.simbolos.cierraLlav);
		l.add(AnalizadorSintactico.simbolos.C);
		l.add(AnalizadorSintactico.simbolos.abreLlav);
		l.add(AnalizadorSintactico.simbolos.elseS);
		Regla r10 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.nueve);
		Regla r11 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.trece);
		l.add(AnalizadorSintactico.simbolos.cierraLlav);
		l.add(AnalizadorSintactico.simbolos.C);
		l.add(AnalizadorSintactico.simbolos.abreLlav);
		l.add(AnalizadorSintactico.simbolos.doce);
		l.add(AnalizadorSintactico.simbolos.cierraPar);
		l.add(AnalizadorSintactico.simbolos.once);
		l.add(AnalizadorSintactico.simbolos.A);
		l.add(AnalizadorSintactico.simbolos.abrePar);
		l.add(AnalizadorSintactico.simbolos.diez);
		l.add(AnalizadorSintactico.simbolos.id);
		l.add(AnalizadorSintactico.simbolos.H);
		l.add(AnalizadorSintactico.simbolos.function);
		l.add(AnalizadorSintactico.simbolos.tres);
		Regla r12 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.catorce);
		l.add(AnalizadorSintactico.simbolos.T);
		Regla r13 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.quince);
		l.add(AnalizadorSintactico.simbolos.voidS);
		Regla r14 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.cuarentaynueve);
		l.add(AnalizadorSintactico.simbolos.K);
		l.add(AnalizadorSintactico.simbolos.dieciseis);
		l.add(AnalizadorSintactico.simbolos.id);
		l.add(AnalizadorSintactico.simbolos.T);
		Regla r15 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.quince);
		l.add(AnalizadorSintactico.simbolos.voidS);
		Regla r16 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.cuarentaynueve);
		l.add(AnalizadorSintactico.simbolos.K);
		l.add(AnalizadorSintactico.simbolos.diecisiete);
		l.add(AnalizadorSintactico.simbolos.id);
		l.add(AnalizadorSintactico.simbolos.T);
		l.add(AnalizadorSintactico.simbolos.coma);
		Regla r17 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.dieciocho);
		Regla r18 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.diecinueve);
		l.add(AnalizadorSintactico.simbolos.C);
		l.add(AnalizadorSintactico.simbolos.B);
		Regla r19 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.veinte);
		Regla r20 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.veintiuno);
		l.add(AnalizadorSintactico.simbolos.intS);
		Regla r21 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.veintidos);
		l.add(AnalizadorSintactico.simbolos.booleanS);
		Regla r22 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.veintitres);
		l.add(AnalizadorSintactico.simbolos.stringS);
		Regla r23 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.veinticuatro);
		l.add(AnalizadorSintactico.simbolos.SS);
		l.add(AnalizadorSintactico.simbolos.id);
		Regla r24 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.veinticinco);
		l.add(AnalizadorSintactico.simbolos.puntComa);
		l.add(AnalizadorSintactico.simbolos.E);
		l.add(AnalizadorSintactico.simbolos.output);
		Regla r25 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.veintiseis);
		l.add(AnalizadorSintactico.simbolos.puntComa);
		l.add(AnalizadorSintactico.simbolos.id);
		l.add(AnalizadorSintactico.simbolos.input);
		Regla r26 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.cuarentayocho);
		l.add(AnalizadorSintactico.simbolos.puntComa);
		l.add(AnalizadorSintactico.simbolos.X);
		l.add(AnalizadorSintactico.simbolos.returnS);
		Regla r27 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.veintisiete);
		l.add(AnalizadorSintactico.simbolos.puntComa);
		l.add(AnalizadorSintactico.simbolos.E);
		l.add(AnalizadorSintactico.simbolos.igual);
		Regla r28 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.veintiocho);
		l.add(AnalizadorSintactico.simbolos.puntComa);
		l.add(AnalizadorSintactico.simbolos.cierraPar);
		l.add(AnalizadorSintactico.simbolos.L);
		l.add(AnalizadorSintactico.simbolos.abrePar);
		Regla r29 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.veintinueve);
		l.add(AnalizadorSintactico.simbolos.Q);
		l.add(AnalizadorSintactico.simbolos.E);
		Regla r30 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.treinta);
		Regla r31 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.treintaiuno);
		l.add(AnalizadorSintactico.simbolos.Q);
		l.add(AnalizadorSintactico.simbolos.E);
		l.add(AnalizadorSintactico.simbolos.coma);
		Regla r32 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.treintaidos);
		Regla r33 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.treintaitres);
		l.add(AnalizadorSintactico.simbolos.E);
		Regla r34 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.treintaicuatro);
		Regla r35 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.treintaicinco);
		l.add(AnalizadorSintactico.simbolos.EE);
		l.add(AnalizadorSintactico.simbolos.R);
		Regla r36 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.treintaiseis);
		l.add(AnalizadorSintactico.simbolos.EE);
		l.add(AnalizadorSintactico.simbolos.R);
		l.add(AnalizadorSintactico.simbolos.menor);
		Regla r37 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.treintaisiete);
		Regla r38 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.treintaiocho);
		l.add(AnalizadorSintactico.simbolos.RR);
		l.add(AnalizadorSintactico.simbolos.U);
		Regla r39 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.treintainueve);
		l.add(AnalizadorSintactico.simbolos.RR);
		l.add(AnalizadorSintactico.simbolos.U);
		l.add(AnalizadorSintactico.simbolos.resta);
		Regla r40 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.cuarenta);
		Regla r41 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.cuarentayuno);
		l.add(AnalizadorSintactico.simbolos.V);
		l.add(AnalizadorSintactico.simbolos.distinto);
		Regla r42 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.cuarentaydos);
		l.add(AnalizadorSintactico.simbolos.UU);
		l.add(AnalizadorSintactico.simbolos.V);
		Regla r43 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.cuarentaytres);
		l.add(AnalizadorSintactico.simbolos.UU);
		l.add(AnalizadorSintactico.simbolos.masmas);
		Regla r44 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.cuarentaycuatro);
		Regla r45 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.cuarentaycinco);
		l.add(AnalizadorSintactico.simbolos.J);
		l.add(AnalizadorSintactico.simbolos.id);
		Regla r46 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.cuarentayseis);
		l.add(AnalizadorSintactico.simbolos.cierraPar);
		l.add(AnalizadorSintactico.simbolos.E);
		l.add(AnalizadorSintactico.simbolos.abrePar);
		Regla r47 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.veintiuno);
		l.add(AnalizadorSintactico.simbolos.ent);
		Regla r48 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.veintitres);
		l.add(AnalizadorSintactico.simbolos.cad);
		Regla r49 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.cincuenta);
		l.add(AnalizadorSintactico.simbolos.cierraPar);
		l.add(AnalizadorSintactico.simbolos.L);
		l.add(AnalizadorSintactico.simbolos.abrePar);
		Regla r50 = new Regla(l,i++);
		
		l= new ArrayList<>();
		l.add(AnalizadorSintactico.simbolos.cuarentaysiete);
		Regla r51 = new Regla(l,i++);
		
		// Regla 1
		i = AnalizadorSintactico.simbolosNoTerminales.PP.ordinal();
		reg[i][AnalizadorSintactico.simbolosTerminales.eof.ordinal()] = r1;
		reg[i][AnalizadorSintactico.simbolosTerminales.var.ordinal()] = r1;
		reg[i][AnalizadorSintactico.simbolosTerminales.id.ordinal()] = r1;
		reg[i][AnalizadorSintactico.simbolosTerminales.function.ordinal()] = r1;
		reg[i][AnalizadorSintactico.simbolosTerminales.output.ordinal()] = r1;
		reg[i][AnalizadorSintactico.simbolosTerminales.input.ordinal()] = r1;
		reg[i][AnalizadorSintactico.simbolosTerminales.returnS.ordinal()] = r1;
		reg[i][AnalizadorSintactico.simbolosTerminales.ifS.ordinal()] = r1;
		
		//Regla 2
		i = AnalizadorSintactico.simbolosNoTerminales.P.ordinal();
		reg[i][AnalizadorSintactico.simbolosTerminales.ifS.ordinal()] = r2;
		reg[i][AnalizadorSintactico.simbolosTerminales.var.ordinal()] = r2;
		reg[i][AnalizadorSintactico.simbolosTerminales.id.ordinal()] = r2;
		reg[i][AnalizadorSintactico.simbolosTerminales.output.ordinal()] = r2;
		reg[i][AnalizadorSintactico.simbolosTerminales.input.ordinal()] = r2;
		reg[i][AnalizadorSintactico.simbolosTerminales.returnS.ordinal()] = r2;
		
		//Regla 3
		reg[i][AnalizadorSintactico.simbolosTerminales.function.ordinal()] = r3;
		
		//Regla 4
		reg[i][AnalizadorSintactico.simbolosTerminales.eof.ordinal()] = r4;
		
		//Regla 6
		i = AnalizadorSintactico.simbolosNoTerminales.B.ordinal();
		reg[i][AnalizadorSintactico.simbolosTerminales.var.ordinal()] = r5;
		
		//Regla 7
		reg[i][AnalizadorSintactico.simbolosTerminales.ifS.ordinal()] = r6;
		
		//Regla 8
		reg[i][AnalizadorSintactico.simbolosTerminales.id.ordinal()] = r7;
		reg[i][AnalizadorSintactico.simbolosTerminales.output.ordinal()] = r7;
		reg[i][AnalizadorSintactico.simbolosTerminales.input.ordinal()] = r7;
		reg[i][AnalizadorSintactico.simbolosTerminales.returnS.ordinal()] = r7;
		
		//Regla 9
		i = AnalizadorSintactico.simbolosNoTerminales.Z.ordinal();
		reg[i][AnalizadorSintactico.simbolosTerminales.id.ordinal()] = r8;
		reg[i][AnalizadorSintactico.simbolosTerminales.output.ordinal()] = r8;
		reg[i][AnalizadorSintactico.simbolosTerminales.input.ordinal()] = r8;
		reg[i][AnalizadorSintactico.simbolosTerminales.returnS.ordinal()] = r8;
		
		//Regla 10
		reg[i][AnalizadorSintactico.simbolosTerminales.abreLlav.ordinal()] = r9;
		
		//Regla 11
		i = AnalizadorSintactico.simbolosNoTerminales.Y.ordinal();
		reg[i][AnalizadorSintactico.simbolosTerminales.elseS.ordinal()] = r10;
		
		//Regla 12
		reg[i][AnalizadorSintactico.simbolosTerminales.eof.ordinal()] = r11;
		reg[i][AnalizadorSintactico.simbolosTerminales.var.ordinal()] = r11;
		reg[i][AnalizadorSintactico.simbolosTerminales.id.ordinal()] = r11;
		reg[i][AnalizadorSintactico.simbolosTerminales.function.ordinal()] = r11;
		reg[i][AnalizadorSintactico.simbolosTerminales.output.ordinal()] = r11;
		reg[i][AnalizadorSintactico.simbolosTerminales.input.ordinal()] = r11;
		reg[i][AnalizadorSintactico.simbolosTerminales.returnS.ordinal()] = r11;
		reg[i][AnalizadorSintactico.simbolosTerminales.ifS.ordinal()] = r11;
		reg[i][AnalizadorSintactico.simbolosTerminales.cierraLlav.ordinal()] = r11;
		
		//Regla 13
		i = AnalizadorSintactico.simbolosNoTerminales.F.ordinal();
		reg[i][AnalizadorSintactico.simbolosTerminales.function.ordinal()] = r12;
		
		//Regla 14
		i = AnalizadorSintactico.simbolosNoTerminales.H.ordinal();
		reg[i][AnalizadorSintactico.simbolosTerminales.intS.ordinal()] = r13;
		reg[i][AnalizadorSintactico.simbolosTerminales.booleanS.ordinal()] = r13;
		reg[i][AnalizadorSintactico.simbolosTerminales.stringS.ordinal()] = r13;
		
		//Regla 15
		reg[i][AnalizadorSintactico.simbolosTerminales.voidS.ordinal()] = r14;
		
		//Regla 16
		i = AnalizadorSintactico.simbolosNoTerminales.A.ordinal();
		reg[i][AnalizadorSintactico.simbolosTerminales.intS.ordinal()] = r15;
		reg[i][AnalizadorSintactico.simbolosTerminales.booleanS.ordinal()] = r15;
		reg[i][AnalizadorSintactico.simbolosTerminales.stringS.ordinal()] = r15;
		
		//Regla 17
		reg[i][AnalizadorSintactico.simbolosTerminales.voidS.ordinal()] = r16;
	
		//Regla 18
		i = AnalizadorSintactico.simbolosNoTerminales.K.ordinal();
		reg[i][AnalizadorSintactico.simbolosTerminales.coma.ordinal()] = r17;
		
		//Regla 19
		reg[i][AnalizadorSintactico.simbolosTerminales.cierraPar.ordinal()] = r18;
		
		//Regla 20
		i = AnalizadorSintactico.simbolosNoTerminales.C.ordinal();
		reg[i][AnalizadorSintactico.simbolosTerminales.ifS.ordinal()] = r19;
		reg[i][AnalizadorSintactico.simbolosTerminales.var.ordinal()] = r19;
		reg[i][AnalizadorSintactico.simbolosTerminales.id.ordinal()] = r19;
		reg[i][AnalizadorSintactico.simbolosTerminales.output.ordinal()] = r19;
		reg[i][AnalizadorSintactico.simbolosTerminales.input.ordinal()] = r19;
		reg[i][AnalizadorSintactico.simbolosTerminales.returnS.ordinal()] = r19;
		
		//Regla 21
		reg[i][AnalizadorSintactico.simbolosTerminales.cierraLlav.ordinal()] = r20;
		
		//Regla 22
		i = AnalizadorSintactico.simbolosNoTerminales.T.ordinal();
		reg[i][AnalizadorSintactico.simbolosTerminales.intS.ordinal()] = r21;
		
		//Regla 23
		reg[i][AnalizadorSintactico.simbolosTerminales.booleanS.ordinal()] = r22;
		
		//Regla 24
		reg[i][AnalizadorSintactico.simbolosTerminales.stringS.ordinal()] = r23;
		
		//Regla 25
		i = AnalizadorSintactico.simbolosNoTerminales.S.ordinal();
		reg[i][AnalizadorSintactico.simbolosTerminales.id.ordinal()] = r24;
	
		//Regla 26
		reg[i][AnalizadorSintactico.simbolosTerminales.output.ordinal()] = r25;
	
		//Regla 27
		reg[i][AnalizadorSintactico.simbolosTerminales.input.ordinal()] = r26;
	
		//Regla 28
		reg[i][AnalizadorSintactico.simbolosTerminales.returnS.ordinal()] = r27;
		
		//Regla 29
		i = AnalizadorSintactico.simbolosNoTerminales.SS.ordinal();
		reg[i][AnalizadorSintactico.simbolosTerminales.igual.ordinal()] = r28;
		
		//Regla 30
		reg[i][AnalizadorSintactico.simbolosTerminales.abrePar.ordinal()] = r29;
		
		//Regla 31
		i = AnalizadorSintactico.simbolosNoTerminales.L.ordinal();
		reg[i][AnalizadorSintactico.simbolosTerminales.distinto.ordinal()] = r30;
		reg[i][AnalizadorSintactico.simbolosTerminales.id.ordinal()] = r30;
		reg[i][AnalizadorSintactico.simbolosTerminales.abrePar.ordinal()] = r30;
		reg[i][AnalizadorSintactico.simbolosTerminales.ent.ordinal()] = r30;
		reg[i][AnalizadorSintactico.simbolosTerminales.cad.ordinal()] = r30;
		
		//Regla 32
		reg[i][AnalizadorSintactico.simbolosTerminales.cierraPar.ordinal()] = r31;
		
		//Regla 33
		i = AnalizadorSintactico.simbolosNoTerminales.Q.ordinal();
		reg[i][AnalizadorSintactico.simbolosTerminales.coma.ordinal()] = r32;
		
		//Regla 34
		reg[i][AnalizadorSintactico.simbolosTerminales.cierraPar.ordinal()] = r33;
	
		//Regla 35
		i = AnalizadorSintactico.simbolosNoTerminales.X.ordinal();
		reg[i][AnalizadorSintactico.simbolosTerminales.distinto.ordinal()] = r34;
		reg[i][AnalizadorSintactico.simbolosTerminales.id.ordinal()] = r34;
		reg[i][AnalizadorSintactico.simbolosTerminales.abrePar.ordinal()] = r34;
		reg[i][AnalizadorSintactico.simbolosTerminales.ent.ordinal()] = r34;
		reg[i][AnalizadorSintactico.simbolosTerminales.cad.ordinal()] = r34;
		
		//Regla 36
		reg[i][AnalizadorSintactico.simbolosTerminales.puntComa.ordinal()] = r35;
		
		//Regla 37
		i = AnalizadorSintactico.simbolosNoTerminales.E.ordinal();
		reg[i][AnalizadorSintactico.simbolosTerminales.distinto.ordinal()] = r36;
		reg[i][AnalizadorSintactico.simbolosTerminales.id.ordinal()] = r36;
		reg[i][AnalizadorSintactico.simbolosTerminales.abrePar.ordinal()] = r36;
		reg[i][AnalizadorSintactico.simbolosTerminales.ent.ordinal()] = r36;
		reg[i][AnalizadorSintactico.simbolosTerminales.cad.ordinal()] = r36;
		
		//Regla 38
		i = AnalizadorSintactico.simbolosNoTerminales.EE.ordinal();
		reg[i][AnalizadorSintactico.simbolosTerminales.menor.ordinal()] = r37;
		
		//Regla 39
		reg[i][AnalizadorSintactico.simbolosTerminales.coma.ordinal()] = r38;
		reg[i][AnalizadorSintactico.simbolosTerminales.puntComa.ordinal()] = r38;
		reg[i][AnalizadorSintactico.simbolosTerminales.cierraPar.ordinal()] = r38;
		
		//Regla 40
		i = AnalizadorSintactico.simbolosNoTerminales.R.ordinal();
		reg[i][AnalizadorSintactico.simbolosTerminales.distinto.ordinal()] = r39;
		reg[i][AnalizadorSintactico.simbolosTerminales.id.ordinal()] = r39;
		reg[i][AnalizadorSintactico.simbolosTerminales.abrePar.ordinal()] = r39;
		reg[i][AnalizadorSintactico.simbolosTerminales.ent.ordinal()] = r39;
		reg[i][AnalizadorSintactico.simbolosTerminales.cad.ordinal()] = r39;
		
		//Regla 41
		i = AnalizadorSintactico.simbolosNoTerminales.RR.ordinal();
		reg[i][AnalizadorSintactico.simbolosTerminales.resta.ordinal()] = r40;
		
		//Regla 42
		reg[i][AnalizadorSintactico.simbolosTerminales.coma.ordinal()] = r41;
		reg[i][AnalizadorSintactico.simbolosTerminales.puntComa.ordinal()] = r41;
		reg[i][AnalizadorSintactico.simbolosTerminales.cierraPar.ordinal()] = r41;
		reg[i][AnalizadorSintactico.simbolosTerminales.menor.ordinal()] = r41;
		
		//Regla 43
		i = AnalizadorSintactico.simbolosNoTerminales.U.ordinal();
		reg[i][AnalizadorSintactico.simbolosTerminales.distinto.ordinal()] = r42;
		
		//Regla 44
		reg[i][AnalizadorSintactico.simbolosTerminales.id.ordinal()] = r43;
		reg[i][AnalizadorSintactico.simbolosTerminales.abrePar.ordinal()] = r43;
		reg[i][AnalizadorSintactico.simbolosTerminales.ent.ordinal()] = r43;
		reg[i][AnalizadorSintactico.simbolosTerminales.cad.ordinal()] = r43;
		
		//Regla 45
		i = AnalizadorSintactico.simbolosNoTerminales.UU.ordinal();
		reg[i][AnalizadorSintactico.simbolosTerminales.masmas.ordinal()] = r44;
		
		//Regla 46
		reg[i][AnalizadorSintactico.simbolosTerminales.coma.ordinal()] = r45;
		reg[i][AnalizadorSintactico.simbolosTerminales.puntComa.ordinal()] = r45;
		reg[i][AnalizadorSintactico.simbolosTerminales.cierraPar.ordinal()] = r45;
		reg[i][AnalizadorSintactico.simbolosTerminales.menor.ordinal()] = r45;
		reg[i][AnalizadorSintactico.simbolosTerminales.resta.ordinal()] = r45;
		
		//Regla 47
		i = AnalizadorSintactico.simbolosNoTerminales.V.ordinal();
		reg[i][AnalizadorSintactico.simbolosTerminales.id.ordinal()] = r46;
		
		//Regla 48
		reg[i][AnalizadorSintactico.simbolosTerminales.abrePar.ordinal()] = r47;
		
		//Regla 49
		reg[i][AnalizadorSintactico.simbolosTerminales.ent.ordinal()] = r48;
		
		//Regla 50
		reg[i][AnalizadorSintactico.simbolosTerminales.cad.ordinal()] = r49;
		
		//Regla 51
		i = AnalizadorSintactico.simbolosNoTerminales.J.ordinal();
		reg[i][AnalizadorSintactico.simbolosTerminales.abrePar.ordinal()] = r50;
		
		//Regla 52
		
		reg[i][AnalizadorSintactico.simbolosTerminales.coma.ordinal()] = r51;
		reg[i][AnalizadorSintactico.simbolosTerminales.puntComa.ordinal()] = r51;
		reg[i][AnalizadorSintactico.simbolosTerminales.cierraPar.ordinal()] = r51;
		reg[i][AnalizadorSintactico.simbolosTerminales.menor.ordinal()] = r51;
		reg[i][AnalizadorSintactico.simbolosTerminales.resta.ordinal()] = r51;
		reg[i][AnalizadorSintactico.simbolosTerminales.masmas.ordinal()] = r51;
	}

}
