package com.exodus.MLBBDialog;

import android.content.Context;
import android.graphics.Typeface;
import com.exodus.MLBBDialog.options.Style;

/**
* Created by Andrei De Ocampo
* https://github.com/sudoxE7
* ytexodus7@gmail.com
* on 10/01/23.
*/

public class MLBBDialogBuilder {
	private Typeface typeface;
	private boolean bold, cancelable;
	private String title, subtitle, okLabel, koLabel;
	private Context context;
	private Style style;
	private MLBBDialogClickListener positiveListener;
	private MLBBDialogClickListener negativeListener;

	public MLBBDialogBuilder(Context context, Style style) {
		this.context = context;
		this.style = style;
	}

	public MLBBDialogBuilder setTitle(String title) {
		this.title = title;
		return this;
	}

	public MLBBDialogBuilder setSubtitle(String subtitle) {
		this.subtitle = subtitle;
		return this;
	}

	public MLBBDialogBuilder setBoldPositiveLabel(boolean bold) {
		this.bold = bold;
		return this;
	}

	public MLBBDialogBuilder setFont(Typeface typeface) {
		this.typeface = typeface;
		return this;
	}

	public MLBBDialogBuilder setCancelable(boolean cancelable) {
		this.cancelable = cancelable;
		return this;
	}

	public MLBBDialogBuilder setNegativeListener(String koLabel, MLBBDialogClickListener listener) {
		this.negativeListener = listener;
		this.koLabel = koLabel;
		return this;
	}

	public MLBBDialogBuilder setPositiveListener(String okLabel, MLBBDialogClickListener listener) {
		this.positiveListener = listener;
		this.okLabel = okLabel;
		return this;
	}

	public MLBBDialog build() {
		MLBBDialog dialog = new MLBBDialog(context, style, title, subtitle, typeface, cancelable);
		dialog.setNegative(koLabel, negativeListener);
		dialog.setPositive(okLabel, positiveListener);
		return dialog;
	}

}