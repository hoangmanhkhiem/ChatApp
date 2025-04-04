package com.example.chatapp.api;

import com.example.chatapp.models.request.AccountModels.*;
import com.example.chatapp.models.request.ChatModels.*;
import com.example.chatapp.models.request.TokenModels.*;
import com.example.chatapp.models.request.UserModels.*;
import com.example.chatapp.models.response.ResponseData;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.http.*;

public interface ChatAppService {

    // ============ Account Management ============

    @POST("/v1/user/register")
    Call<ResponseData<Object>> registerUser(@Body RegisterInput input);

    @POST("/v1/user/verify_account")
    Call<ResponseData<Object>> verifyAccount(@Body VerifyInput input);

    @POST("/v1/user/upgrade_password_register")
    Call<ResponseData<Object>> upgradePasswordRegister(@Body UpdatePasswordInput input);

    @POST("/v1/user/login")
    Call<ResponseData<Object>> login(@Body LoginInput input);

    @POST("/v1/user/refresh_token")
    Call<ResponseData<Object>> refreshToken(@Body RefreshTokenInput input);

    @POST("/v1/user/logout")
    Call<ResponseData<Object>> logout(@Body RefreshTokenInput input);

    @POST("/v1/user/forgot_password")
    Call<ResponseData<Object>> forgotPassword(@Query("mail") String mail);

    // ============ User Management ============

    @GET("/v1/user/get_user_info")
    Call<ResponseData<Object>> getUserInfo(@Header("Authorization") String token);

    @PUT("/v1/user/update_user_info")
    Call<ResponseData<Object>> updateUserInfo(
            @Header("Authorization") String token,
            @Body UpdateUserInfoInput input);

    @PUT("/v1/user/update_password")
    Call<ResponseData<Object>> updatePassword(
            @Header("Authorization") String token,
            @Body UserChangePasswordInput input);

    @GET("/v1/user/find_user")
    Call<ResponseData<Object>> findUser(
            @Header("Authorization") String token,
            @Query("email") String email);

    // ============ Friend Management ============

    @POST("/v1/user/create_friend_request")
    Call<ResponseData<Object>> createFriendRequest(
            @Header("Authorization") String token,
            @Body CreateFriendRequestInput input);

    @GET("/v1/user/get_list_friend_request")
    Call<ResponseData<Object>> getListFriendRequest(
            @Header("Authorization") String token,
            @Query("limit") int limit,
            @Query("page") int page);

    @POST("/v1/user/accept_friend_request")
    Call<ResponseData<Object>> acceptFriendRequest(
            @Header("Authorization") String token,
            @Body AcceptFriendRequestInput input);

    @POST("/v1/user/reject_friend_request")
    Call<ResponseData<Object>> rejectFriendRequest(
            @Header("Authorization") String token,
            @Body RejectFriendRequestInput input);

    @DELETE("/v1/user/end_friend_request")
    Call<ResponseData<Object>> endFriendRequest(
            @Header("Authorization") String token,
            @Body EndFriendRequestInput input);

    @DELETE("/v1/user/delete_friend")
    Call<ResponseData<Object>> deleteFriend(
            @Header("Authorization") String token,
            @Body DeleteFriendInput input);

    // ============ Chat Management ============

    @POST("/v1/chat/create-chat-private")
    Call<ResponseData<Object>> createChatPrivate(
            @Header("Authorization") String token,
            @Body CreateChatPrivateInput input);

    @POST("/v1/chat/create-chat-group")
    Call<ResponseData<Object>> createChatGroup(
            @Header("Authorization") String token,
            @Body CreateChatGroupInput input);

    @GET("/v1/chat/get-chat-info")
    Call<ResponseData<Object>> getChatInfo(
            @Header("Authorization") String token,
            @Query("chat_id") String chatId);

    @PUT("/v1/chat/upgrade-chat-info")
    Call<ResponseData<Object>> upgradeChatInfo(
            @Header("Authorization") String token,
            @Body UpgradeChatInfoInput input);

    @POST("/v1/chat/add-member-to-chat")
    Call<ResponseData<Object>> addMemberToChat(
            @Header("Authorization") String token,
            @Body AddMemberToChatInput input);

    @DELETE("/v1/chat/del-men-from-chat")
    Call<ResponseData<Object>> deleteMemberFromChat(
            @Header("Authorization") String token,
            @Body DelMenForChatInput input);

    @PUT("/v1/chat/change-admin-group-chat")
    Call<ResponseData<Object>> changeAdminGroupChat(
            @Header("Authorization") String token,
            @Body ChangeAdminGroupChatInput input);

    @DELETE("/v1/chat/del-chat")
    Call<ResponseData<Object>> deleteChat(
            @Header("Authorization") String token,
            @Body DelChatInput input);

    @GET("/v1/chat/get-list-chat-for-user")
    Call<ResponseData<Object>> getListChatForUser(
            @Header("Authorization") String token,
            @Query("limit") int limit,
            @Query("page") int page);

    @GET("/v1/chat/get-user-in-chat")
    Call<ResponseData<Object>> getUserInChat(
            @Header("Authorization") String token,
            @Query("chat_id") String chatId,
            @Query("limit") int limit,
            @Query("page") int page);

    // ============ Token Management ============

    @POST("/v1/token/create_token")
    Call<ResponseData<Object>> createToken(@Body JwtInput input);

    @POST("/v1/token/create_refresh_token")
    Call<ResponseData<Object>> createRefreshToken(@Body JwtInput input);

    @POST("/v1/token/valid_token")
    Call<ResponseData<Object>> validateToken(@Body JwtInput input);

    // ============ Microservice ============

    @GET("/v1/mservice/get-user-in-chat")
    Call<ResponseData<Object>> getMicroserviceUserInChat(
            @Header("Authorization") String token,
            @Query("chat_id") String chatId,
            @Query("limit") int limit,
            @Query("page") int page);
}