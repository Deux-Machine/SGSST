package org.fundacionview.sgsst.util;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.fundacionview.sgsst.modelos.Ausentismo;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class AusentismoExporterPDF {
	private List<Ausentismo> listaAusentismo;

	public AusentismoExporterPDF(List<Ausentismo> listaAusentismo) {
		super();
		this.listaAusentismo = listaAusentismo;
	}

	private void escribirCabeceraDeLaTabla(PdfPTable tabla) {
		PdfPCell celda = new PdfPCell();

		celda.setBackgroundColor(Color.BLUE);
		celda.setPadding(5);

		Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
		fuente.setColor(Color.WHITE);

		celda.setPhrase(new Phrase("ID", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Nombre", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Apellido", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Tipo Inc", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Diagnostico CIE", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("EPS", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Area", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Salario", fuente));
		tabla.addCell(celda);
	}

	private void escribirDatosDeLaTabla(PdfPTable tabla) {
		for (Ausentismo incapacidad : listaAusentismo) {
			tabla.addCell(String.valueOf(incapacidad.getId()));
			tabla.addCell(incapacidad.getNombre());
			tabla.addCell(incapacidad.getApellidos());
			tabla.addCell(incapacidad.getTipoIncapacidad());
			tabla.addCell(incapacidad.getCodigoDiagnosti());
			tabla.addCell(incapacidad.getEPS());
			tabla.addCell(incapacidad.getAreaTrabajo());
			tabla.addCell(String.valueOf(incapacidad.getSalario()));
		}
	}

	public void exportar(HttpServletResponse response) throws DocumentException, IOException {
		Document documento = new Document(PageSize.A4);
		PdfWriter.getInstance(documento, response.getOutputStream());

		documento.open();

		Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		fuente.setColor(Color.BLUE);
		fuente.setSize(18);

		Paragraph titulo = new Paragraph("Lista de Ausentismo", fuente);
		titulo.setAlignment(Paragraph.ALIGN_CENTER);
		documento.add(titulo);

		PdfPTable tabla = new PdfPTable(8);
		tabla.setWidthPercentage(100);
		tabla.setSpacingBefore(15);
		tabla.setWidths(new float[] { 1f, 2.3f, 2.3f, 2.3f, 2.9f, 2f, 2.9f, 2.9f });
		tabla.setWidthPercentage(110);

		escribirCabeceraDeLaTabla(tabla);
		escribirDatosDeLaTabla(tabla);

		documento.add(tabla);
		documento.close();
	}
}

