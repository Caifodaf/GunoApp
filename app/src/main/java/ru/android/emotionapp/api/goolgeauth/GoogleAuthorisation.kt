package ru.android.emotionapp.api.goolgeauth

import android.content.ContentValues
import android.content.Intent
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task

class GoogleAuthorisation {

    fun signIn(requireActivity: FragmentActivity) {
        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        // Build a GoogleSignInClient with the options specified by gso.
        val mGoogleSignInClient = GoogleSignIn.getClient(requireActivity, gso);
        Log.e("AAA", "Activity mGoogleSignInClient - $mGoogleSignInClient")


        val signInIntent: Intent = mGoogleSignInClient.signInIntent
        //startActivityForResult(signInIntent, RC_SIGN_IN)
        //getResult.launch(signInIntent)
    }

    //private val getResult =
    //    registerForActivityResult(
    //        ActivityResultContracts.StartActivityForResult()) {
    //        if(it.resultCode == Activity.RESULT_OK){
    //        //    val value = it.data?.getStringExtra("input")
    //        //}
    //        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
    //        //if (it.resultCode == SING_IN) {
    //        // The Task returned from this call is always completed, no need to attach
    //        // a listener.
    //        val task: Task<GoogleSignInAccount> =
    //            GoogleSignIn.getSignedInAccountFromIntent(it.data)
    //        handleSignInResult(task);
    //        Log.e("AAA","Activity google ok - ${it.resultCode} $task")
    //        }
    //    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            Log.e("AAA", "Activity google handle - ${account.account}")
            Log.e("AAA", "Activity google handle - ${account.displayName}")
            Log.e("AAA", "Activity google handle - ${account.email}")
            Log.e("AAA", "Activity google handle - ${account.idToken}")
            Log.e("AAA", "Activity google handle - ${account.photoUrl}")

            // Signed in successfully, show authenticated UI.
            //updateUI(account)
        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(ContentValues.TAG, "signInResult:failed code=" + e.statusCode)
            //updateUI(null)
        }
    }
}