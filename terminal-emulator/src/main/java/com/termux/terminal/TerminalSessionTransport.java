package com.termux.terminal;

/**
 * External byte transport for a {@link TerminalSession} whose process and PTY
 * are owned by the embedding application.
 *
 * <p>The transport receives user input produced by the terminal view and PTY
 * resize notifications. Remote output is delivered in the opposite direction
 * through {@link TerminalSession#append(byte[], int, int)}.</p>
 */
public interface TerminalSessionTransport {

    /** Write terminal input to the externally managed process or connection. */
    void write(byte[] data, int offset, int count);

    /** Notify the externally managed PTY about a terminal size change. */
    void resize(int columns, int rows, int cellWidthPixels, int cellHeightPixels);

    /** Close the externally managed transport. */
    void close();
}
