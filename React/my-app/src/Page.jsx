import React from "react";
import AdminPage from "./AdminPage";
import UserPage from "./UserPage";

export default function Page() {
  const userType = "admin";

  return (
    <>
	    <h1>나의 앱</h1>
      {userType === "admin" ? <AdminPage></AdminPage> : <UserPage></UserPage>}
    </>
  );
}