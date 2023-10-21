package com.exodus.MLBBDialogDemo;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.exodus.MLBBDialog.MLBBDialog;
import com.exodus.MLBBDialog.MLBBDialogBuilder;
import com.exodus.MLBBDialog.MLBBDialogClickListener;
import com.exodus.MLBBDialog.options.Style;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		try {
			new MLBBDialogBuilder(MainActivity.this, Style.NEW)
					.setTitle(getString(R.string.title))
					.setSubtitle(getString(R.string.subtitle))
					.setCancelable(true)
					.setPositiveListener(getString(R.string.positive), new MLBBDialogClickListener() {
						@Override
						public void onClick(MLBBDialog mLBBDialog) {
							finishAffinity();
							mLBBDialog.dismiss();
						}
					})
					.setNegativeListener(getString(R.string.negative), new MLBBDialogClickListener() {
						@Override
						public void onClick(MLBBDialog mLBBDialog) {
							mLBBDialog.dismiss();
						}
					})
					.build().show();
		} catch (Exception exception) {
			Toast.makeText(MainActivity.this, exception.getMessage(), Toast.LENGTH_LONG).show();
		}
	}
}