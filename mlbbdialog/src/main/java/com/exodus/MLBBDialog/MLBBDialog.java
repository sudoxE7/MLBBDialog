package com.exodus.MLBBDialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.exodus.MLBBDialog.options.Style;

/**
* Created by Andrei De Ocampo
* https://github.com/sudoxE7
* ytexodus7@gmail.com
* on 10/01/23.
*/

public class MLBBDialog {
	private Dialog dialog;
	private TextView dialogButtonOk, dialogButtonNo;
	private TextView title_lbl, subtitle_lbl;
	private View separator;
	private MLBBDialogClickListener positiveListener;
	private MLBBDialogClickListener negativeListener;
	private boolean negativeExist;
	private static final String LOG_ERROR = "iOSDialog_ERROR";

	public MLBBDialog(Context context, Style style, String title, String subtitle, Typeface typeFace,
			boolean cancelable) {
		negativeExist = false;
		dialog = new Dialog(context);
		switch (style) {
		case OLD:
			dialog.setContentView(R.layout.mlbb_dialog_old_layout);
			break;
		case NEW:
			dialog.setContentView(R.layout.mlbb_dialog_new_layout);
			break;
		}
		if (dialog.getWindow() != null)
			dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

		initViews();

		dialog.setCancelable(cancelable);

		setTitle(title);
		setSubtitle(subtitle);
		setTypefaces(typeFace);

		initEvents();
	}

	public void setPositive(String okLabel, MLBBDialogClickListener listener) {
		this.positiveListener = listener;
		this.dismiss();
		setPositiveLabel(okLabel);
	}

	public void setNegative(String koLabel, MLBBDialogClickListener listener) {
		if (listener != null) {
			this.negativeListener = listener;
			this.dismiss();
			negativeExist = true;
			setNegativeLabel(koLabel);
		}
	}

	public void show() {
		if (!negativeExist) {
			dialogButtonNo.setVisibility(View.GONE);
			separator.setVisibility(View.GONE);
		}
		dialog.show();
	}

	public void dismiss() {
		dialog.dismiss();
	}

	public void setTitle(String title) {
		title_lbl.setText(title);
	}

	public void setSubtitle(String subtitle) {
		subtitle_lbl.setText(subtitle);
	}

	private void setPositiveLabel(String positive) {
		dialogButtonOk.setText(positive);
	}

	private void setNegativeLabel(String negative) {
		dialogButtonNo.setText(negative);
	}

	private void setTypefaces(Typeface yourFont) {
		if (yourFont != null) {
			title_lbl.setTypeface(yourFont);
			subtitle_lbl.setTypeface(yourFont);
			dialogButtonOk.setTypeface(yourFont);
			dialogButtonNo.setTypeface(yourFont);
		}
	}

	private void initViews() {
		title_lbl = dialog.findViewById(R.id.title);
		subtitle_lbl = dialog.findViewById(R.id.subtitle);
		dialogButtonOk = dialog.findViewById(R.id.dialogButtonOK);
		dialogButtonNo = dialog.findViewById(R.id.dialogButtonNO);
		separator = dialog.findViewById(R.id.separator);
	}

	private void initEvents() {
		dialogButtonOk.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (positiveListener != null) {
					positiveListener.onClick(MLBBDialog.this);
				}
			}
		});
		dialogButtonNo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (negativeListener != null) {
					negativeListener.onClick(MLBBDialog.this);
				}
			}
		});
	}

}